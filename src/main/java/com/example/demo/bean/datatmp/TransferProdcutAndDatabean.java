package com.example.demo.bean.datatmp;

import com.example.demo.bean.Motor;
import com.example.demo.bean.Product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

        //TODO


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


        List<ElecData> elecDatas = new ArrayList<>();

        List<Motor> motors = product.getMotors();

//        private AxServo axServo;
//
//        private List<NameMinMaxAveCur> nameMinMaxAveCurs = new ArrayList<>();

        AxServo axServoX = null;
        AxServo axServoY = null;
        AxServo axServoZ = null;
        AxServo axServoA = null;

        List<NameMinMaxAveCur> nameMinMaxAveCurXs = null;
        List<NameMinMaxAveCur> nameMinMaxAveCurYs = null;
        List<NameMinMaxAveCur> nameMinMaxAveCurZs = null;
        List<NameMinMaxAveCur> nameMinMaxAveCurAs = null;



        for (Motor motor : motors) {

            switch (motor.getAxisName()) {

                case "X":
                    if(axServoX == null) {

                        axServoX = new AxServo();
                        nameMinMaxAveCurXs = new ArrayList<>();

                        axServoX.setAxisName(motor.getAxisName());
                        axServoX.setElecId(motor.getElecId());
                        axServoX.setElecModel(motor.getElecModel());
                        axServoX.setServoId(motor.getServoId());
                        axServoX.setServoModel(motor.getServoModel());

                    }

                    NameMinMaxAveCur nameMinMaxAveCurX = new NameMinMaxAveCur();

                    nameMinMaxAveCurX.setName(motor.getElecName());
                    nameMinMaxAveCurX.setAverage(motor.getAverage());
                    nameMinMaxAveCurX.setCur(motor.getCur());
                    nameMinMaxAveCurX.setMax(motor.getMax());
                    nameMinMaxAveCurX.setMin(motor.getMin());

                    nameMinMaxAveCurXs.add(nameMinMaxAveCurX);

                    break;

                case "Y":

                    if(axServoY == null) {

                        axServoY = new AxServo();
                        nameMinMaxAveCurYs = new ArrayList<>();

                        axServoY.setAxisName(motor.getAxisName());
                        axServoY.setElecId(motor.getElecId());
                        axServoY.setElecModel(motor.getElecModel());
                        axServoY.setServoId(motor.getServoId());
                        axServoY.setServoModel(motor.getServoModel());

                    }

                    NameMinMaxAveCur nameMinMaxAveCurY = new NameMinMaxAveCur();

                    nameMinMaxAveCurY.setName(motor.getElecName());
                    nameMinMaxAveCurY.setAverage(motor.getAverage());
                    nameMinMaxAveCurY.setCur(motor.getCur());
                    nameMinMaxAveCurY.setMax(motor.getMax());
                    nameMinMaxAveCurY.setMin(motor.getMin());

                    nameMinMaxAveCurYs.add(nameMinMaxAveCurY);

                    break;

                case "Z":
                    if(axServoZ == null) {

                        axServoZ = new AxServo();
                        nameMinMaxAveCurZs = new ArrayList<>();

                        axServoZ.setAxisName(motor.getAxisName());
                        axServoZ.setElecId(motor.getElecId());
                        axServoZ.setElecModel(motor.getElecModel());
                        axServoZ.setServoId(motor.getServoId());
                        axServoZ.setServoModel(motor.getServoModel());
                    }


                    NameMinMaxAveCur nameMinMaxAveCurZ = new NameMinMaxAveCur();

                    nameMinMaxAveCurZ.setName(motor.getElecName());
                    nameMinMaxAveCurZ.setAverage(motor.getAverage());
                    nameMinMaxAveCurZ.setCur(motor.getCur());
                    nameMinMaxAveCurZ.setMax(motor.getMax());
                    nameMinMaxAveCurZ.setMin(motor.getMin());

                    nameMinMaxAveCurZs.add(nameMinMaxAveCurZ);


                    break;

                case "A":
                    if(axServoA == null) {

                        axServoA = new AxServo();
                        nameMinMaxAveCurAs = new ArrayList<>();

                        axServoA.setAxisName(motor.getAxisName());
                        axServoA.setElecId(motor.getElecId());
                        axServoA.setElecModel(motor.getElecModel());
                        axServoA.setServoId(motor.getServoId());
                        axServoA.setServoModel(motor.getServoModel());

                    }

                    NameMinMaxAveCur nameMinMaxAveCurA = new NameMinMaxAveCur();

                    nameMinMaxAveCurA.setName(motor.getElecName());
                    nameMinMaxAveCurA.setAverage(motor.getAverage());
                    nameMinMaxAveCurA.setCur(motor.getCur());
                    nameMinMaxAveCurA.setMax(motor.getMax());
                    nameMinMaxAveCurA.setMin(motor.getMin());

                    nameMinMaxAveCurAs.add(nameMinMaxAveCurA);


                    break;
            }


        }

        if(axServoX != null) {
            ElecData elecData = new ElecData();
            elecData.setAxServo(axServoX);
            elecData.setNameMinMaxAveCurs(nameMinMaxAveCurXs);

            elecDatas.add(elecData);
        }


        if(axServoY != null) {
            ElecData elecData = new ElecData();
            elecData.setAxServo(axServoY);
            elecData.setNameMinMaxAveCurs(nameMinMaxAveCurYs);

            elecDatas.add(elecData);
        }

        if(axServoZ != null) {
            ElecData elecData = new ElecData();
            elecData.setAxServo(axServoZ);
            elecData.setNameMinMaxAveCurs(nameMinMaxAveCurZs);

            elecDatas.add(elecData);
        }


        if(axServoA != null) {
            ElecData elecData = new ElecData();
            elecData.setAxServo(axServoA);
            elecData.setNameMinMaxAveCurs(nameMinMaxAveCurAs);

            elecDatas.add(elecData);
        }

        /***********************4.elecDatas************************************/
        dataBean.setElecDatas(elecDatas);

        return dataBean;
    }



}
