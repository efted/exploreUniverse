package universe.earth.creature;

import org.apache.log4j.Logger;
import universe.earth.SettingUtil.SuccesUtil;
import universe.earth.creature.birth.BirthUtil;

public class MainClass {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(MainClass.class);
        BirthUtil birthUtil = new BirthUtil();
        SuccesUtil succesUtil = birthUtil.generate();
        logger.info(succesUtil.getStatus());
        logger.info(succesUtil.getMessage());

    }
}
