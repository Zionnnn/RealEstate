/**
 * @author Junyi Zhang
 * @user Junyi Zhang
 * @package PACKAGE_NAME
 * @create 2022-10-21 20:05
 * @description RealEstate
 */
public class House {
    private String houseID;
    private String houseAddress;
    private String houseType; // such as Apartment, Unit, Townhouse,etc.
    private double housePrice;
    private int numBedrooms;
    private int numBathrooms;
    private int numCarspace;// number of available parking
    private double sizeHouse;
    private String descriptionHouse;

    public House() {
    }

    public House(String id, String address, String type, double price, int bedrooms, int bathrooms,
                 int carspace, double size, String description) {
        this.houseID = id;
        this.houseAddress = address;
        this.houseType = type;
        this.housePrice = price;
        this.numBedrooms = bedrooms;
        this.numBathrooms = bathrooms;
        this.numCarspace = carspace;
        this.sizeHouse = size;
        this.descriptionHouse = description;

    }

    /**
     * // Add the information of a new house to a TXT file
     * // if the house information meets the defined conditions,
     * //the information should be added to the TXT file and the function should return true
     * // if the house information does not meet the defined conditions, the information
     * //should not be added to the TXT file and the function should return false
     *
     * @return
     */
    public boolean AddHouse() {

        //Verify that houseID meets the requirements
        Boolean checkHouseID = HouseAddValidationUtil.checkHouseID(this.houseID);

        //Check whether the descriptionHouse meets the requirement
        Boolean checkDescriptionHouse = HouseAddValidationUtil.checkDescriptionHouse(this.descriptionHouse);


        //Check whether numBedrooms and numBathrooms meet the requirements
        Boolean checkBedAndBathRoomNum = HouseAddValidationUtil.checkBedAndBathRoomNum(this.numBedrooms, this.numBathrooms);

        //Verify that sizeHouse and housePrice meet the requirements
        Boolean checkSizeHouseAndHousePrice = HouseAddValidationUtil.checkSizeHouseAndHousePrice(this.sizeHouse, this.housePrice);

        //Verify that houseType and numCarspace meet the requirements
        Boolean checkHouseTypeAndNumCarspace = HouseAddValidationUtil.checkHouseTypeAndNumCarspace(this.houseType, this.numCarspace);

        //Check that housePrice meets the requirements
        Boolean checkHousePrice = HouseAddValidationUtil.checkHousePrice(this.housePrice);

        //Check its housePrice and numBedrooms and numBathrooms for meeting requirements
        Boolean checkBedAndBathRoomNumAndPrice = HouseAddValidationUtil.checkBedAndBathRoomNumAndPrice(this.housePrice, numBedrooms, numBathrooms);

        //Save the file only when all conditions are met
        if (checkHouseID && checkDescriptionHouse && checkBedAndBathRoomNum
                && checkSizeHouseAndHousePrice && checkHouseTypeAndNumCarspace && checkHousePrice
                && checkBedAndBathRoomNumAndPrice
        ) {
            FileUtil.addHouse(this);
            return true;
        }
        return false;
    }

    public boolean UpdateHouse(String newAddress, String newType, double newPrice, int newBedrooms,
                               int newBathrooms, int newCarspace, double newSize, String newDescription) {

        /**
         *It should not be possible to increase the price of houses with less than three bedrooms by more than 10%.
         *  The price of other houses can be increased by up to 20%
         */
        if (newBathrooms < 3 && (newPrice / this.housePrice - 1 > 0.1)) {
            return false;
        }
        //The price of other houses can be increased by up to 20%
        if (newPrice / this.housePrice > 1.2) {
            return false;
        }

        // For all types of houses, except for “Townhouse", it should not be possible to change the address.
        if (!"TownHose".equals(newType) && !newDescription.equals(this.descriptionHouse)) {
            return false;
        }

        //The size of a house can be increased by between 5% and 10%
        if (newSize / this.sizeHouse > 1.1) {
            return false;
        }
        this.houseAddress = newAddress;
        this.houseType = newType;
        this.housePrice = newPrice;
        this.numBedrooms = newBedrooms;
        this.numBathrooms = newBathrooms;
        this.numCarspace = newCarspace;
        this.sizeHouse = newSize;
        this.descriptionHouse = newDescription;
        return this.AddHouse();
// Update the information of a given house in a TXT file
// if the house's new information meets the defined conditions,
//the house information should be updated in the TXT file and the function should return true.
// if the house's new information does not meet the defined conditions,
//the house information should not be updated in the TXT file and the function should return false.
    }


    public String getHouseID() {
        return houseID;
    }

    public void setHouseID(String houseID) {
        this.houseID = houseID;
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public double getHousePrice() {
        return housePrice;
    }

    public void setHousePrice(double housePrice) {
        this.housePrice = housePrice;
    }

    public int getNumBedrooms() {
        return numBedrooms;
    }

    public void setNumBedrooms(int numBedrooms) {
        this.numBedrooms = numBedrooms;
    }

    public int getNumBathrooms() {
        return numBathrooms;
    }

    public void setNumBathrooms(int numBathrooms) {
        this.numBathrooms = numBathrooms;
    }

    public int getNumCarspace() {
        return numCarspace;
    }

    public void setNumCarspace(int numCarspace) {
        this.numCarspace = numCarspace;
    }

    public double getSizeHouse() {
        return sizeHouse;
    }

    public void setSizeHouse(double sizeHouse) {
        this.sizeHouse = sizeHouse;
    }

    public String getDescriptionHouse() {
        return descriptionHouse;
    }

    public void setDescriptionHouse(String descriptionHouse) {
        this.descriptionHouse = descriptionHouse;
    }

    @Override
    public String toString() {
        return "House{" +
                "houseID='" + houseID + '\'' +
                ", houseAddress='" + houseAddress + '\'' +
                ", houseType='" + houseType + '\'' +
                ", housePrice=" + housePrice +
                ", numBedrooms=" + numBedrooms +
                ", numBathrooms=" + numBathrooms +
                ", numCarspace=" + numCarspace +
                ", sizeHouse=" + sizeHouse +
                ", descriptionHouse='" + descriptionHouse + '\'' +
                '}';
    }
}

