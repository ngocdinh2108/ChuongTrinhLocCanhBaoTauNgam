import java.io.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Handling {

    public static int count = 0;
    public static BlockingQueue shipPositionsByTime = new LinkedBlockingDeque();
    public static final String POSITIONS_FILE_PATH = "/home/dinhngocdinh/Downloads/Thread/positions.txt";
    public static final String AREA_FILE_PATH = "/home/dinhngocdinh/Downloads/Thread/area.txt";

    public synchronized void savePositionFileToQueue() {
        StringBuffer result = readFile(POSITIONS_FILE_PATH);
        for (String line : result.toString().split("\n")) {
            shipPositionsByTime.offer(line);
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count++;
    }

    public synchronized void getDataFromQueue() {
        if (!shipPositionsByTime.isEmpty()) {
            String infoNow = (String) shipPositionsByTime.poll();
            String[] arrShipInfo = infoNow.split("[|]");
            ShipInfo shipInfoNow = new ShipInfo(arrShipInfo[0], arrShipInfo[1], arrShipInfo[2], arrShipInfo[3]);
            StringBuffer getFileArea = readFile(AREA_FILE_PATH);
            for (String lineFileArea : getFileArea.toString().split("\n")) {
                String[] arrAreaInfo = lineFileArea.split("[|]");
                AreaInfo areaInfo = new AreaInfo(arrAreaInfo[0], arrAreaInfo[1], arrAreaInfo[2], arrAreaInfo[3], arrAreaInfo[4]);
                if ((Integer.parseInt(shipInfoNow.getLongitude()) >= Integer.parseInt(areaInfo.getLongitudeLeft())) && (Integer.parseInt(shipInfoNow.getLongitude()) <= Integer.parseInt(areaInfo.getLongitudeRight()))) {
                    if ((Integer.parseInt(shipInfoNow.getLatitude()) >= Integer.parseInt(areaInfo.getLatitudeBot())) && (Integer.parseInt(shipInfoNow.getLatitude()) <= Integer.parseInt(areaInfo.getLatitudeTop()))) {
                        String content = shipInfoNow.getMmsi() + "|Canh bao xam nhap vung|" + areaInfo.getNameArea() + "|" + shipInfoNow.getLongitude() + "|" + shipInfoNow.getLatitude() + "|" + shipInfoNow.getTime();
                        writeFile("alert.txt",content);
                    }
                }
            }
        }
        notifyAll();
    }

    public StringBuffer readFile(String url) {
        StringBuffer result = new StringBuffer();
        try {
            FileReader fileReader = new FileReader(url);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while (true) {
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }

                result.append(line);
                result.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void writeFile(String outPutFileName, String content) {
        try {
            FileWriter fileWriter = new FileWriter(outPutFileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(content.toString());
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ghi that bai!");
        }
    }
}
