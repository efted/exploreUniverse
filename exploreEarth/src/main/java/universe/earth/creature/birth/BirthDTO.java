package universe.earth.creature.birth;

//import org.apache.log4j.Logger;

public class BirthDTO {
    //private static final Logger logger = Logger.getLogger(BirthDTO.class);

    private String id;
    private String type;
    private String time;
    private String ipv4;
    private String ipv6;
    private String code;
    private String status;
    private String remark;

    public BirthDTO() {
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }
    public String getTime() {
        return time;
    }
    public String getIpv4() {
        return ipv4;
    }
    public String getIpv6() {
        return ipv6;
    }

    public String getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

    public String getRemark() {
        return remark;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setIpv4(String ipv4) {
        this.ipv4 = ipv4;
    }

    public void setIpv6(String ipv6) {
        this.ipv6 = ipv6;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
