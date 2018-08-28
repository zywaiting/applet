package com.zy.applet.test;

import com.zy.applet.utils.Utils;

import java.util.List;

public class TestJson {


    public static void main(String[] args) {
        String x = "{\n" +
                "\t\"transHeader\": {\n" +
                "\t\t\"preferLangId\": \"211\",\n" +
                "\t\t\"requestId\": \"1007002201807051048351530758915538755\",\n" +
                "\t\t\"requestTime\": \"2018-07-05 10:48:35\",\n" +
                "\t\t\"transType\": 1007028\n" +
                "\t},\n" +
                "\t\"transRequest\": {\n" +
                "\t\t\"policies\": [{\n" +
                "\t\t\t\"policy\": {\n" +
                "\t\t\t\t\"policyNo\": \"2310023401\",\n" +
                "\t\t\t\t\"sumAssured\": \"10000\",\n" +
                "\t\t\t\t\"currentPaymentDate\":\"2007-10-10\",\n" +
                "\t\t\t\t\"mainCoverageName\": \"安途交通意外伤害保险B款\",\n" +
                "\t\t\t\t\"name\": \"李英俊\",\n" +
                "\t\t\t\t\"certiType\": \"1\",\n" +
                "\t\t\t\t\"certiCode\": \"422428196605063959\"\n" +
                "\t\t\t}\n" +
                "\t\t}, {\n" +
                "\t\t\t\"policy\": {\n" +
                "\t\t\t\t\"policyNo\": \"2310023402\",\n" +
                "\t\t\t\t\"sumAssured\": \"10000\",\n" +
                "\t\t\t\t\"currentPaymentDate\":\"2007-10-10\",\n" +
                "\t\t\t\t\"mainCoverageName\": \"安途交通意外伤害保险B款\",\n" +
                "\t\t\t\t\"name\": \"李英俊\",\n" +
                "\t\t\t\t\"certiType\": \"1\",\n" +
                "\t\t\t\t\"certiCode\": \"422428196605063959\"\n" +
                "\t\t\t}\n" +
                "\t\t}, {\n" +
                "\t\t\t\"policy\": {\n" +
                "\t\t\t\t\"policyNo\": \"2310023403\",\n" +
                "\t\t\t\t\"sumAssured\": \"10000\",\n" +
                "\t\t\t\t\"currentPaymentDate\":\"2007-10-10\",\n" +
                "\t\t\t\t\"mainCoverageName\": \"安途交通意外伤害保险B款\",\n" +
                "\t\t\t\t\"name\": \"李英俊\",\n" +
                "\t\t\t\t\"certiType\": \"1\",\n" +
                "\t\t\t\t\"certiCode\": \"422428196605063959\"\n" +
                "\t\t\t}\n" +
                "\t\t}]\n" +
                "\t}\n" +
                "}";
        Result json = Utils.json(x, Result.class);
        System.out.println(json.getTransRequest().getPolicies().get(0).getPolicy().getCertiCode());
    }

    public static class Result{
        private TransHeader transHeader;
        private TransRequest transRequest;

        public TransHeader getTransHeader() {
            return transHeader;
        }

        public void setTransHeader(TransHeader transHeader) {
            this.transHeader = transHeader;
        }

        public TransRequest getTransRequest() {
            return transRequest;
        }

        public void setTransRequest(TransRequest transRequest) {
            this.transRequest = transRequest;
        }
    }

    public static class TransHeader{
        private String preferLangId;
        private String requestId;
        private String requestTime;
        private Integer transType;

        public String getPreferLangId() {
            return preferLangId;
        }

        public void setPreferLangId(String preferLangId) {
            this.preferLangId = preferLangId;
        }

        public String getRequestId() {
            return requestId;
        }

        public void setRequestId(String requestId) {
            this.requestId = requestId;
        }

        public String getRequestTime() {
            return requestTime;
        }

        public void setRequestTime(String requestTime) {
            this.requestTime = requestTime;
        }

        public Integer getTransType() {
            return transType;
        }

        public void setTransType(Integer transType) {
            this.transType = transType;
        }
    }

    public static class TransRequest{
        private List<Policies> policies;

        public List<Policies> getPolicies() {
            return policies;
        }

        public void setPolicies(List<Policies> policies) {
            this.policies = policies;
        }
    }

    public static class Policies{
        private Policy policy;

        public Policy getPolicy() {
            return policy;
        }

        public void setPolicy(Policy policy) {
            this.policy = policy;
        }
    }

    private static class Policy{
        private String policyNo;
        private String sumAssured;
        private String currentPaymentDate;
        private String mainCoverageName;
        private String name;
        private String certiCode;
        private String certiType;

        public String getCertiType() {
            return certiType;
        }

        public void setCertiType(String certiType) {
            this.certiType = certiType;
        }

        public String getMainCoverageName() {
            return mainCoverageName;
        }

        public void setMainCoverageName(String mainCoverageName) {
            this.mainCoverageName = mainCoverageName;
        }

        public String getPolicyNo() {
            return policyNo;
        }

        public void setPolicyNo(String policyNo) {
            this.policyNo = policyNo;
        }

        public String getSumAssured() {
            return sumAssured;
        }

        public void setSumAssured(String sumAssured) {
            this.sumAssured = sumAssured;
        }

        public String getCurrentPaymentDate() {
            return currentPaymentDate;
        }

        public void setCurrentPaymentDate(String currentPaymentDate) {
            this.currentPaymentDate = currentPaymentDate;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCertiCode() {
            return certiCode;
        }

        public void setCertiCode(String certiCode) {
            this.certiCode = certiCode;
        }
    }
    /*{
        "transHeader": {
        "preferLangId": "211",
                "requestId": "1007002201807051048351530758915538755",
                "requestTime": "2018-07-05 10:48:35",
                "transType": 1007028
    },
        "transRequest": {
        "policies": [{
            "policy": {
                "policyNo": "2310023401",//保单号
                        "sumAssured": "10000",//汇总金额//总保费
                        "currentPaymentDate":"2007-10-10",//最近一期应缴费日期
                        "mainCoverageName": "安途交通意外伤害保险B款",//主险名称
                        "name": "李英俊",//投保人
                        "certiType": "1",//证件类型
                        "certiCode": "422428196605063959"//证件号码
            }
        }, {
            "policy": {
                "policyNo": "2310023402",//保单号
                        "sumAssured": "10000",//汇总金额//总保费
                        "currentPaymentDate":"2007-10-10",//最近一期应缴费日期
                        "mainCoverageName": "安途交通意外伤害保险B款",//主险名称
                        "name": "李英俊",//投保人
                        "certiType": "1",//证件类型
                        "certiCode": "422428196605063959"//证件号码
            }
        }, {
            "policy": {
                "policyNo": "2310023403",//保单号
                        "sumAssured": "10000",//汇总金额//总保费
                        "currentPaymentDate":"2007-10-10",//最近一期应缴费日期
                        "mainCoverageName": "安途交通意外伤害保险B款",//主险名称
                        "name": "李英俊",//投保人
                        "certiType": "1",//证件类型
                        "certiCode": "422428196605063959"//证件号码
            }
        }]
    }
    }*/

}
