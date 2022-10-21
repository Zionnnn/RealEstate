import java.io.*;

/**
 * @author Junyi Zhang
 * @user Junyi Zhang
 * @package PACKAGE_NAME
 * @create 2022-10-21 20:51
 * @description RealEstate
 */
public class FileUtil {
    public static void addHouse(House house) {
        try {
            deleteHouse(house.getHouseID());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File file = new File("House.txt");
            //if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
            //true = append file
            FileWriter fileWritter = new FileWriter(file.getName(), true);
            fileWritter.write(house.toString() + "\n");
            fileWritter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // Delete the old house before updating it
    public static void deleteHouse(String houseId) throws Exception {
        File file = new File("House.txt");
        String rl = null;
        StringBuffer bf = new StringBuffer();
        BufferedReader br = new BufferedReader(new FileReader(file));
        while ((rl = br.readLine()) != null) {
            rl = rl.trim();
            if (rl.indexOf(houseId) == -1) { //或者!r1.startsWith(special)
                bf.append(rl).append("\r\n");
            }
        }
        br.close();
        BufferedWriter out = new BufferedWriter(new FileWriter(file));
        out.write(bf.toString());
        out.flush();
        out.close();
    }
}
