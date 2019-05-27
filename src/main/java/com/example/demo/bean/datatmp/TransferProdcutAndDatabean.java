package com.example.demo.bean.datatmp;

import com.example.demo.bean.Motor;
import com.example.demo.bean.Product;

import java.io.Serializable;
import java.util.*;

public class TransferProdcutAndDatabean implements Serializable {

    private static final long serialVersionUID = -4774049239286077731L;

    public static Product dataBeanToProduct(DataBean dataBean) {

        Product product = new Product();

        /********************1.uploadTime----loginname*************************/
        product.setUploadTime(dataBean.getUploadTime());
        product.setVersion(dataBean.getVersion());
        product.setMacAxNum(dataBean.getMacAxNum());

        product.setMacModel(dataBean.getMacModel());
        product.setMacNO(dataBean.getMacNO());
        product.setMacSN(dataBean.getMacSN());

        product.setIpcCode(dataBean.getIpcCode());
        product.setContractCode(dataBean.getContractCode());
        product.setCustomerName(dataBean.getCustomerName());
        product.setLoginName(dataBean.getLoginName());

        /********************2.ncVer************************************/
        product.setNcVer(dataBean.getNcVer());


        /********************3.servoVer*************************/
        product.setServos(dataBean.getServos());

        /********************4.elecDataList*************************/

        List<Motor> motors = new ArrayList<>();

        List<ElecData> elecDatas = dataBean.getElecDatas();

        for (ElecData elecData : elecDatas) {
            AxServo axServo = elecData.getAxServo();
            List<NameMinMaxAveCur> nameMinMaxAveCurs = elecData.getNameMinMaxAveCurs();

            for (NameMinMaxAveCur nameMinMaxAveCur : nameMinMaxAveCurs) {
                Motor motor = new Motor();

                motor.setAxisName(axServo.getAxisName());
                motor.setServoId(axServo.getServoId());
                motor.setElecId(axServo.getElecId());
                motor.setServoModel(axServo.getServoModel());
                motor.setElecModel(axServo.getElecModel());

                motor.setElecName(nameMinMaxAveCur.getName());
                motor.setMin(nameMinMaxAveCur.getMin());
                motor.setMax(nameMinMaxAveCur.getMax());
                motor.setAverage(nameMinMaxAveCur.getAverage());
                motor.setCur(nameMinMaxAveCur.getCur());


                motors.add(motor);
            }

        }

        product.setMotors(motors);

        return product;
    }


    public static DataBean productToDataBean(Product product) {
        DataBean dataBean = new DataBean();


        /********************1.uploadTime----loginname*************************/
        dataBean.setUploadTime(product.getUploadTime());
        dataBean.setVersion(product.getVersion());
        dataBean.setMacAxNum(product.getMacAxNum());

        dataBean.setMacModel(product.getMacModel());
        dataBean.setMacNO(product.getMacNO());
        dataBean.setMacSN(product.getMacSN());

        dataBean.setIpcCode(product.getIpcCode());
        dataBean.setContractCode(product.getContractCode());
        dataBean.setCustomerName(product.getCustomerName());
        dataBean.setLoginName(product.getLoginName());

        /********************2.ncVer************************************/
        dataBean.setNcVer(product.getNcVer());


        /********************3.servos*************************/

        dataBean.setServos(product.getServos());


        /***********************4.elecDatas************************************/

        List<Motor> motors = product.getMotors();

        List<ElecData> elecDatas = new ArrayList<>();

        List<AxServo> axServos = new ArrayList<>();

        List<List<NameMinMaxAveCur>> nameMinMaxAveCurss = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();

        for(Motor motor :motors) {

            String axisName = motor.getAxisName();

            if( !map.containsKey(axisName) ) {
                map.put(axisName, map.size());
                axServos.add(new AxServo());
                nameMinMaxAveCurss.add(new ArrayList<>());
            }

            int i = map.get(axisName).intValue();

            AxServo axServo = axServos.get(i);
            List<NameMinMaxAveCur> nameMinMaxAveCurs = nameMinMaxAveCurss.get(i);



            axServo.setAxisName(motor.getAxisName());
            axServo.setElecId(motor.getElecId());
            axServo.setElecModel(motor.getElecModel());
            axServo.setServoId(motor.getServoId());
            axServo.setServoModel(motor.getServoModel());

            NameMinMaxAveCur nameMinMaxAveCur = new NameMinMaxAveCur();

            nameMinMaxAveCur.setName(motor.getElecName());
            nameMinMaxAveCur.setAverage(motor.getAverage());
            nameMinMaxAveCur.setCur(motor.getCur());
            nameMinMaxAveCur.setMax(motor.getMax());
            nameMinMaxAveCur.setMin(motor.getMin());

            nameMinMaxAveCurs.add(nameMinMaxAveCur);

        }

        for(int i = 0; i < axServos.size(); i++) {
            ElecData elecData = new ElecData();
            elecData.setAxServo(axServos.get(i));
            elecData.setNameMinMaxAveCurs(nameMinMaxAveCurss.get(i));

            elecDatas.add(elecData);
        }

        dataBean.setElecDatas(elecDatas);

        return dataBean;
    }





    public static List<Product> dataBeansToProducts(List<DataBean> dataBeans) {

        List<Product> ret = new ArrayList<>();

        for (DataBean dataBean : dataBeans) {
            ret.add(dataBeanToProduct(dataBean));
        }

        return ret;
    }

    public static List<DataBean> productsToDataBeans(List<Product> products) {
        List<DataBean> ret = new ArrayList<>();

        for (Product product : products) {
            ret.add(productToDataBean(product));
        }

        return ret;
    }

}
