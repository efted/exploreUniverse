package universe.earth.creature.birth;

import org.apache.log4j.Logger;
import universe.earth.SettingUtil.JdbcUtil;
import universe.earth.SettingUtil.SuccesUtil;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


public class BirthUtil {
    private static final Logger logger = Logger.getLogger(BirthUtil.class);

    private BirthDTO birthDTO = new BirthDTO();

    //生成uuid
    public static String getUUID() {
        String uuid = UUID.randomUUID().toString();
        //去掉“-”符号
        return uuid.replaceAll("-", "");
    }

    //获取当前系统时间 格式化为 yyyy-MM-dd HH:mm:ss
    public static String Time() {
        java.util.Date currentTime = new Date();
        java.text.SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(currentTime);
    }

    //获取当前系统ipv4地址
    public static String Ipv4() {
        String ipv4 = "";
        try {
            ipv4 = InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e) {
            logger.debug(e.getMessage());
        }
        return ipv4;
    }

    //获取当前系统ipv6地址
    public static String Ipv6() {
        String ipv6 = "";
        try {
            ipv6 = Inet6Address.getLocalHost().getHostAddress();
        } catch (Exception e) {
            logger.debug(e.getMessage());
        }
        return ipv6;
    }

    public SuccesUtil generate() {
        SuccesUtil succesUtil = new SuccesUtil();
        try {
            this.birthDTO.setId(getUUID());
            this.birthDTO.setType("人类");
            this.birthDTO.setTime(Time());
            this.birthDTO.setIpv4(Ipv4());
            this.birthDTO.setIpv6(Ipv6());
            this.birthDTO.setCode("human");
            this.birthDTO.setStatus("1");
            this.birthDTO.setRemark("人类已创建");
            Connection connection = JdbcUtil.getConnection();
            String sql = "insert into T_CREATURE_TYPE(id,type,operation_time,operation_ipv4,operation_ipv6,type_code,status,remark) values(?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = null;
            int rows = 0;
            if (connection != null) {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, this.birthDTO.getId());
                preparedStatement.setString(2, this.birthDTO.getType());
                preparedStatement.setString(3, this.birthDTO.getTime());
                preparedStatement.setString(4, this.birthDTO.getIpv4());
                preparedStatement.setString(5, this.birthDTO.getIpv6());
                preparedStatement.setString(6, this.birthDTO.getCode());
                preparedStatement.setString(7, this.birthDTO.getStatus());
                preparedStatement.setString(8, this.birthDTO.getRemark());
                rows = preparedStatement.executeUpdate();
            }
            logger.info("INSERT执行成功，表中插入了" + rows + "条数据");
            JdbcUtil.closeResource(null, preparedStatement, connection);
            succesUtil.setStatus("1");
            succesUtil.setMessage(this.birthDTO.getType() + "创建成功");
            return succesUtil;
        } catch (Exception e) {
            logger.debug(e.getMessage());
            succesUtil.setStatus("0");
            succesUtil.setMessage("创建失败:" + e.getMessage());
            return succesUtil;
        }
    }

    public void setBirthDTO(BirthDTO birthDTO) {
        this.birthDTO = birthDTO;
    }
    public BirthDTO getBirthDTO() {
        return birthDTO;
    }
}
