import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Junyi Zhang
 * @user Junyi Zhang
 * @package PACKAGE_NAME
 * @create 2022-10-21 21:06
 * @description RealEstate
 */
public class HouseTest {

    @Test
    void addHouse() {
        //Test Case 1
        House houseOne =
                new House("ABC1111112", "Osinskichester, Hawaii, United States",
                        "Apartment", 350000,
                        5, 2, 2, 100, "Apartment");

        Assertions.assertTrue(houseOne.AddHouse());

        //Test Case 2
        House houseTwo =
                new House("ABC1111113", "61097 Brendan Harbor, Apt. 002, 01405, Brookeburgh, Vermont, United States",
                        "Unit", 300000,
                        7, 2, 3, 120, "Big Unit");

        Assertions.assertTrue(houseTwo.AddHouse());

        //Test Case 3
        House houseThree =
                new House("ABC1111114", "8116 Walsh Square, Apt. 174, 98543-4665, Tessborough, Tennessee, United States",
                        "Townhouse", 200000,
                        6, 2, 3, 110, "Townhouse");

        Assertions.assertTrue(houseThree.AddHouse());

        //Test Case 4
        House houseFour =
                new House("ABC1111115", "187 Houston Coves, Suite 116, 42337, North Evanstad, Hawaii, United States",
                        "Unit", 300000,
                        5, 1, 3, 100, "Big Unit");

        Assertions.assertTrue(houseFour.AddHouse());

        //Test Case 5
        House houseFive =
                new House("ABC1111116", "27822 Pfannerstill Burg, Suite 224, 57733-8979, East Ismaelhaven, Connecticut, United States",
                        "Unit", 310000,
                        6, 1, 3, 150, "Townhouse");

        Assertions.assertTrue(houseFive.AddHouse());
    }

    @Test
    void updateHouse() {

        //Test Case 1
        House houseOne =
                new House("ABC1111112", "Osinskichester, Hawaii, United States",
                        "Apartment", 350000,
                        5, 2, 2, 100, "Apartment");

        boolean houseOneUpdate = houseOne.UpdateHouse("Hawaii, United States", "Apartment", 350000, 5, 2, 2, 100, "Apartment");
        Assertions.assertTrue(houseOneUpdate);

        //Test Case 2
        House houseTwo =
                new House("ABC1111113", "61097 Brendan Harbor, Apt. 002, 01405, Brookeburgh, Vermont, United States",
                        "Unit", 300000,
                        7, 2, 3, 120, "Big Unit");
        boolean houseTwoUpdate = houseTwo.UpdateHouse("Apt. 002, 01405, Brookeburgh, Vermont", "TownHose", 300000, 5, 2, 2, 100, "TownHose");

        Assertions.assertTrue(houseTwoUpdate);


    }

}
