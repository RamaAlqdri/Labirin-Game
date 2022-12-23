public class Map {
    Graph dataMap;
    public void makemap() {
        dataMap =  new Graph();

        dataMap.addVertex("Start");
        for(int i = 1; i<=36; i++){
            dataMap.addVertex(Integer.toString(i));
        }
        dataMap.addVertex("Finish");


        dataMap.insertEdge("Start","1","Bottom");
        dataMap.insertEdge("1","Start","Top");
        dataMap.insertEdge("1","2","Bottom");
        dataMap.insertEdge("2","1","Top");
        dataMap.insertEdge("2","3","Left");
        dataMap.insertEdge("3","2","Right");
        dataMap.insertEdge("3","4","Left");
        dataMap.insertEdge("4","3","Right");
        dataMap.insertEdge("4","5","Top");
        dataMap.insertEdge("4","7","Bottom");
        dataMap.insertEdge("5","4","Bottom");
        dataMap.insertEdge("5","6","Right");
        dataMap.insertEdge("6","5","Left");
        dataMap.insertEdge("7","4","Top");
        dataMap.insertEdge("7","8","Right");
        dataMap.insertEdge("8","9","Right");
        dataMap.insertEdge("8","7","Left");
        dataMap.insertEdge("9","8","Left");
        dataMap.insertEdge("9","10","Bottom");
        dataMap.insertEdge("9","18","Right");
        dataMap.insertEdge("10","9","Top");
        dataMap.insertEdge("10","11","Bottom");
        dataMap.insertEdge("11","10","Top");
        dataMap.insertEdge("11","12","Left");
        dataMap.insertEdge("12","11","Right");
        dataMap.insertEdge("12","13","Top");
        dataMap.insertEdge("13","12","Bottom");
        dataMap.insertEdge("13","14","Left");
        dataMap.insertEdge("14","13","Right");
        dataMap.insertEdge("14","15","Bottom");
        dataMap.insertEdge("15","14","Top");
        dataMap.insertEdge("15","16","Bottom");
        dataMap.insertEdge("16","15","Top");
        dataMap.insertEdge("16","17","Right");
        dataMap.insertEdge("17","16","Left");
        dataMap.insertEdge("18","9","Left");
        dataMap.insertEdge("18","19","Top");
        dataMap.insertEdge("18","25","Right");
        dataMap.insertEdge("19","18","Bottom");
        dataMap.insertEdge("19","20","Top");
        dataMap.insertEdge("20","19","Bottom");
        dataMap.insertEdge("20","21","Right");
        dataMap.insertEdge("21","20","Left");
        dataMap.insertEdge("21","22","Right");
        dataMap.insertEdge("22","21","Left");
        dataMap.insertEdge("22","23","Bottom");
        dataMap.insertEdge("23","22","Top");
        dataMap.insertEdge("23","24","Left");
        dataMap.insertEdge("24","23","Right");
        dataMap.insertEdge("25","18","Left");
        dataMap.insertEdge("25","26","Right");
        dataMap.insertEdge("26","25","Left");
        dataMap.insertEdge("26","27","Bottom");
        dataMap.insertEdge("27","26","Top");
        dataMap.insertEdge("27","28","Left");
        dataMap.insertEdge("28","27","Right");
        dataMap.insertEdge("28","29","Left");
        dataMap.insertEdge("29","28","Right");
        dataMap.insertEdge("29","30","Bottom");
        dataMap.insertEdge("30","29","Top");
        dataMap.insertEdge("30","31","Right");
        dataMap.insertEdge("31","30","Left");
        dataMap.insertEdge("31","32","Right");
        dataMap.insertEdge("32","31","Left");
        dataMap.insertEdge("32","33","Bottom");
        dataMap.insertEdge("33","32","Top");
        dataMap.insertEdge("33","34","Left");
        dataMap.insertEdge("34","33","Right");
        dataMap.insertEdge("34","35","Left");
        dataMap.insertEdge("35","34","Right");
        dataMap.insertEdge("35","Finish","Bottom");
        dataMap.insertEdge("35","36","Left");
        dataMap.insertEdge("36","35","Right");
        dataMap.insertEdge("Finish","35","Top");
    }
//    public void makemap() {
//        dataMap =  new Graph();
//
//        dataMap.addVertex("Start");
//        for(int i = 1; i<=196; i++){
//            dataMap.addVertex(Integer.toString(i));
//        }
//        dataMap.addVertex("Finish");
//
//        dataMap.insertEdge("1","2","Right");
//        dataMap.insertEdge("1","15","Bottom");
//        dataMap.insertEdge("2","1","Left");
//        dataMap.insertEdge("2","3","Right");
//        dataMap.insertEdge("3","2","Left");
//        dataMap.insertEdge("3","4","Right");
//        dataMap.insertEdge("3","17","Bottom");
//        dataMap.insertEdge("4","3","Left");
//    }
}
