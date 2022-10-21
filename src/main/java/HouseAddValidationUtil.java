/**
 * @author Junyi Zhang
 * @user Junyi Zhang
 * @package PACKAGE_NAME
 * @create 2022-10-21 20:11
 * @description RealEstate
 */
public class HouseAddValidationUtil {


    public static Boolean checkHouseID(String houseID) {

        if (houseID == null || houseID.length() != 10) {
            return false;
        }
        char[] chars = houseID.toCharArray();
        //Determine if the first three letters are A-Z
        for (int i = 0; i < 3; i++) {
            if (!(chars[i] >= 'A' && chars[i] <= 'Z')) {
                return false;
            }
        }


        //Determine whether the latter 7 is 1-9
        for (int i = 3; i < 10; i++) {
            if (!(chars[i] >= '1' && chars[i] <= '9')) {
                return false;
            }
        }
        //Returns true if both are true
        return true;
    }

    public static Boolean checkDescriptionHouse(String descriptionHouse) {
        if (descriptionHouse == null) {
            return false;
        }
        //Judge the length of descriptionHouse
        if (descriptionHouse.length() < 5 || descriptionHouse.length() > 10) {
            return false;
        }
        return true;
    }

    public static Boolean checkBedAndBathRoomNum(int numBedrooms, int numBathrooms) {
        if (numBedrooms > 4 && numBathrooms <= 2) {
            return true;
        }
        return false;
    }

    public static Boolean checkSizeHouseAndHousePrice(double sizeHouse, double housePrice) {
        if (sizeHouse < 50 || housePrice > 350000) {
            return false;
        }
        return true;
    }

    public static Boolean checkHouseTypeAndNumCarspace(String houseType, int numCarspace) {
        if (houseType == null) {
            return false;
        }
        if (!houseType.equals("Apartment")) {
            return true;
        }
        if (numCarspace >= 1) {
            return true;
        }
        return false;
    }

    public static Boolean checkHousePrice(double housePrice) {
        if (housePrice < 100000 || housePrice > 1500000) {
            return false;
        }
        return true;
    }

    public static Boolean checkBedAndBathRoomNumAndPrice(double housePrice, int numBedrooms, int numBathrooms) {
        if (numBedrooms >= 3 && numBathrooms >= 2 && housePrice > 750000) {
            return false;
        }
        return true;
    }
}
