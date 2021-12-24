package model;

public class OwnerInfo {
    private String idCard;//身份证号
    private String carId;//车牌号
    private String password;//密码
    private String fullName;//车主姓名
    private String phone;//电话
    private String email;//邮件
    private int driveLicense;//驾驶证
    private int illegal;//是否有未处理的违规记录
    private int idImg;//身份证图片上传
    private int carLicense;//行驶证
    private String orderId;//检查单号

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDriveLicense() {
        return driveLicense;
    }

    public void setDriveLicense(int driveLicense) {
        this.driveLicense = driveLicense;
    }

    public int getIllegal() {
        return illegal;
    }

    public void setIllegal(int illegal) {
        this.illegal = illegal;
    }

    public int getIdImg() {
        return idImg;
    }

    public void setIdImg(int idImg) {
        this.idImg = idImg;
    }

    public int getCarLicense() {
        return carLicense;
    }

    public void setCarLicense(int carLicense) {
        this.carLicense = carLicense;
    }
}