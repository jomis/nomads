package at.ac.tuwien.dsg.model;

import at.ac.tuwien.dsg.model.Utilisation;
import com.google.common.collect.Lists;
import jdbm.*;

import java.io.IOException;
import java.util.List;

/**
 * Created by jomis on 29/10/14.
 */


//TODO SPLIT STORES
public class FastKeyValueStore {

    private static String fileName = "nomadsStore";

    private static RecordManager recManager = null;

    private PrimaryStoreMap<Long,Utilisation> utilisations;
    private SecondaryTreeMap<String,Long,Utilisation> sourceIndex;
    private SecondaryTreeMap<String,Long,Utilisation> metricIndex;
    private SecondaryTreeMap<String,Long,Utilisation> groupIndex;


    private PrimaryStoreMap<Long,Deployment> deployments;
    private SecondaryTreeMap<String,Long,Deployment> hostIndex;
    private SecondaryTreeMap<String,Long,Deployment> containerIndex;
    private SecondaryTreeMap<String,Long,Deployment> serviceIndex;
    private SecondaryTreeMap<String,Long,Deployment> typeIndex;


    public FastKeyValueStore () {

        if (recManager == null) {
            try {
                recManager = RecordManagerFactory.createRecordManager(fileName);
                utilisations = recManager.storeMap("utilisations");
                sourceIndex = utilisations.secondaryTreeMap("sourceIndex",
                        new SecondaryKeyExtractor<String, Long, Utilisation>() {
                            @Override
                            public String extractSecondaryKey(Long key, Utilisation utilisation) {
                                return utilisation.getSource();
                            }
                        });
                groupIndex = utilisations.secondaryTreeMap("groupIndex",
                        new SecondaryKeyExtractor<String, Long, Utilisation>() {
                            @Override
                            public String extractSecondaryKey(Long key, Utilisation utilisation) {
                                return utilisation.getGroup();
                            }
                        });

                metricIndex = utilisations.secondaryTreeMap("metricIndex", new SecondaryKeyExtractor<String, Long, Utilisation>() {
                            @Override
                            public String extractSecondaryKey(Long key, Utilisation utilisation) {
                                return utilisation.getMetric();
                            }
                        });


                deployments = recManager.storeMap("deployments");

                hostIndex = deployments.secondaryTreeMap("hostIndex",
                        new SecondaryKeyExtractor<String, Long, Deployment>() {
                            @Override
                            public String extractSecondaryKey(Long key, Deployment deployment) {
                                return deployment.getHost();
                            }
                        });


                containerIndex = deployments.secondaryTreeMap("containerIndex",
                        new SecondaryKeyExtractor<String, Long, Deployment>() {
                            @Override
                            public String extractSecondaryKey(Long key, Deployment deployment) {
                                return deployment.getContainerId();
                            }
                        });

                serviceIndex = deployments.secondaryTreeMap("serviceIndex",
                        new SecondaryKeyExtractor<String, Long, Deployment>() {
                            @Override
                            public String extractSecondaryKey(Long key, Deployment deployment) {
                                return deployment.getServiceId();
                            }
                        });

                typeIndex = deployments.secondaryTreeMap("typeIndex",
                        new SecondaryKeyExtractor<String, Long, Deployment>() {
                            @Override
                            public String extractSecondaryKey(Long key, Deployment deployment) {
                                return deployment.getType();
                            }
                        });

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean storeDeployment (Deployment deployment) {

        deployments.putValue(deployment);

        try {
            recManager.commit();
            return true;
        } catch (IOException e) {
            return false;
        }


    }

    public List<Deployment> getDeploymentByHost(String host) {


        return Lists.newArrayList(hostIndex.getPrimaryValues(host));
    }

    public List<Deployment> getDeploymentByType(String type) {

        return Lists.newArrayList(typeIndex.getPrimaryValues(type));
    }

    public List<Deployment> getDeploymentByService(String service) {
        return Lists.newArrayList(serviceIndex.getPrimaryValues(service));
    }

    public boolean storeUtilisation (Utilisation utilisation) {

        utilisations.putValue(utilisation);

        try {
            recManager.commit();
            return true;
        } catch (IOException e) {
            return false;
        }
    }




    public List<Utilisation> getUtilisationBySource(String source) {

        return Lists.newArrayList(sourceIndex.getPrimaryValues(source));

    }

    public List<Utilisation> getUtilisationByGroup(String group) {
        return Lists.newArrayList(groupIndex.getPrimaryValues(group));
    }

    public List<Utilisation> getUtilisationByMetric(String metric) {

        return Lists.newArrayList(metricIndex.getPrimaryValues(metric));
    }


    public Utilisation getUtilisationByKey(String key) {

        return utilisations.get(Long.parseLong(key));
    }

    public void keyDump() {
        System.out.println("UTILISATIONS:"+utilisations.keySet());
        System.out.println("DEPLOYMENTS:"+deployments.keySet());
    }




}
