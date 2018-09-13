package com.zy.applet.test;

import com.zy.applet.utils.Utils;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class TestXml {


    public static void main(String[] args) {
        String xml = "<?xml version='1.0' encoding='UTF-8'?>\n" +
                "<Response service=\"OrderService\">\n" +
                "<Head>OK</Head>\n" +
                "<Body>\n" +
                "<OrderResponse filter_result=\"2\" destcode=\"020\" mailno=\"444004400791\" origincode=\"755\" orderid=\"QIAO-20180104002\">\n" +
                "\t<rls_info rls_errormsg=\"444004400791:\" invoke_result=\"OK\" rls_code=\"1000\">\n" +
                "\t\t<rls_detail waybillNo=\"444004400791\" sourceTransferCode=\"755W\" sourceCityCode=\"755\" sourceDeptCode=\"755BF\" sourceTeamCode=\"018\" destCityCode=\"020\" destDeptCode=\"020\" destRouteLabel=\"020\" proName=\"顺丰标快\" cargoTypeCode=\"C201\" limitTypeCode=\"T4\" expressTypeCode=\"B1\" xbFlag=\"0\" printFlag=\"000000000\" twoDimensionCode=\"MMM={'k1':'','k2':'020','k3':'','k4':'T4','k5':'444004400791','k6':''}\" proCode=\"T4\" printIcon=\"00000000\" errMsg=\" dest:sssNOT_MATCH_ADDR{&quot;src&quot;:&quot;queryAip&quot;,&quot;flag&quot;:0}\"/>\n" +
                "\t</rls_info>\n" +
                "</OrderResponse>\n" +
                "</Body>\n" +
                "</Response>";
        Response response = Utils.xml(xml, Response.class);
        System.out.println(response.getHead());
    }

    @XmlRootElement(name = "Response")
    public static class Response{
        private String Head;
        private Body body;
        public Body getBody() {
            return body;
        }

        @XmlElement(name = "Body")
        public void setBody(Body body) {
            this.body = body;
        }


        public String getHead() {
            return Head;
        }

        @XmlElement(name = "Head")
        public void setHead(String head) {
            Head = head;
        }
    }

    public static class Body{
        private OrderResponse orderResponse;

        public OrderResponse getOrderResponse() {
            return orderResponse;
        }
        @XmlElement(name = "OrderResponse")
        public void setOrderResponse(OrderResponse orderResponse) {
            this.orderResponse = orderResponse;
        }
    }

    public static class OrderResponse{

        private RlsInfo rlsInfo;
        private String filterResult;
        private String destcode;
        private String mailno;
        private String origincode;
        private String orderid;

        public String getDestcode() {
            return destcode;
        }

        @XmlAttribute(name = "destcode")
        public void setDestcode(String destcode) {
            this.destcode = destcode;
        }

        public String getMailno() {
            return mailno;
        }

        @XmlAttribute(name = "mailno")
        public void setMailno(String mailno) {
            this.mailno = mailno;
        }

        public String getOrigincode() {
            return origincode;
        }

        @XmlAttribute(name = "origincode")
        public void setOrigincode(String origincode) {
            this.origincode = origincode;
        }

        public String getOrderid() {
            return orderid;
        }

        @XmlAttribute(name = "orderid")
        public void setOrderid(String orderid) {
            this.orderid = orderid;
        }

        public String getFilterResult() {
            return filterResult;
        }
        @XmlAttribute(name = "filter_result")
        public void setFilterResult(String filterResult) {
            this.filterResult = filterResult;
        }

        public RlsInfo getRlsInfo() {
            return rlsInfo;
        }
        @XmlElement(name = "rls_info")
        public void setRlsInfo(RlsInfo rlsInfo) {
            this.rlsInfo = rlsInfo;
        }
    }

    public static class RlsInfo{

        private RlsDetail rlsDetail;
        private String rlsErrormsg;
        private String invokeResult;
        private String rlsCode;

        public String getRlsErrormsg() {
            return rlsErrormsg;
        }

        @XmlAttribute(name = "rls_errormsg")
        public void setRlsErrormsg(String rlsErrormsg) {
            this.rlsErrormsg = rlsErrormsg;
        }

        public String getInvokeResult() {
            return invokeResult;
        }

        @XmlAttribute(name = "invoke_result")
        public void setInvokeResult(String invokeResult) {
            this.invokeResult = invokeResult;
        }

        public String getRlsCode() {
            return rlsCode;
        }

        @XmlAttribute(name = "rls_code")
        public void setRlsCode(String rlsCode) {
            this.rlsCode = rlsCode;
        }

        public RlsDetail getRlsDetail() {
            return rlsDetail;
        }

        @XmlElement(name = "rls_detail")
        public void setRlsDetail(RlsDetail rlsDetail) {
            this.rlsDetail = rlsDetail;
        }
    }


    public static class RlsDetail{

        private String waybillNo;
        private String sourceTransferCode;
        private String sourceCityCode;
        private String sourceDeptCode;
        private String sourceTeamCode;
        private String destCityCode;
        private String destDeptCode;
        private String destRouteLabel;
        private String proName;
        private String cargoTypeCode;
        private String limitTypeCode;
        private String expressTypeCode;
        private String xbFlag;
        private String printFlag;
        private String twoDimensionCode;
        private String proCode;
        private String printIcon;
        private String errMsg;

        public String getSourceTransferCode() {
            return sourceTransferCode;
        }

        @XmlAttribute(name = "sourceTransferCode")
        public void setSourceTransferCode(String sourceTransferCode) {
            this.sourceTransferCode = sourceTransferCode;
        }

        public String getSourceCityCode() {
            return sourceCityCode;
        }

        @XmlAttribute(name = "sourceCityCode")
        public void setSourceCityCode(String sourceCityCode) {
            this.sourceCityCode = sourceCityCode;
        }

        public String getSourceDeptCode() {
            return sourceDeptCode;
        }

        @XmlAttribute(name = "sourceDeptCode")
        public void setSourceDeptCode(String sourceDeptCode) {
            this.sourceDeptCode = sourceDeptCode;
        }

        public String getSourceTeamCode() {
            return sourceTeamCode;
        }

        @XmlAttribute(name = "sourceTeamCode")
        public void setSourceTeamCode(String sourceTeamCode) {
            this.sourceTeamCode = sourceTeamCode;
        }

        public String getDestCityCode() {
            return destCityCode;
        }

        @XmlAttribute(name = "destCityCode")
        public void setDestCityCode(String destCityCode) {
            this.destCityCode = destCityCode;
        }

        public String getDestDeptCode() {
            return destDeptCode;
        }

        @XmlAttribute(name = "destDeptCode")
        public void setDestDeptCode(String destDeptCode) {
            this.destDeptCode = destDeptCode;
        }

        public String getDestRouteLabel() {
            return destRouteLabel;
        }

        @XmlAttribute(name = "destRouteLabel")
        public void setDestRouteLabel(String destRouteLabel) {
            this.destRouteLabel = destRouteLabel;
        }

        public String getProName() {
            return proName;
        }

        @XmlAttribute(name = "proName")
        public void setProName(String proName) {
            this.proName = proName;
        }

        public String getCargoTypeCode() {
            return cargoTypeCode;
        }

        @XmlAttribute(name = "cargoTypeCode")
        public void setCargoTypeCode(String cargoTypeCode) {
            this.cargoTypeCode = cargoTypeCode;
        }

        public String getLimitTypeCode() {
            return limitTypeCode;
        }

        @XmlAttribute(name = "limitTypeCode")
        public void setLimitTypeCode(String limitTypeCode) {
            this.limitTypeCode = limitTypeCode;
        }

        public String getExpressTypeCode() {
            return expressTypeCode;
        }

        @XmlAttribute(name = "expressTypeCode")
        public void setExpressTypeCode(String expressTypeCode) {
            this.expressTypeCode = expressTypeCode;
        }

        public String getXbFlag() {
            return xbFlag;
        }

        @XmlAttribute(name = "xbFlag")
        public void setXbFlag(String xbFlag) {
            this.xbFlag = xbFlag;
        }

        public String getPrintFlag() {
            return printFlag;
        }

        @XmlAttribute(name = "printFlag")
        public void setPrintFlag(String printFlag) {
            this.printFlag = printFlag;
        }

        public String getTwoDimensionCode() {
            return twoDimensionCode;
        }

        @XmlAttribute(name = "twoDimensionCode")
        public void setTwoDimensionCode(String twoDimensionCode) {
            this.twoDimensionCode = twoDimensionCode;
        }

        public String getProCode() {
            return proCode;
        }

        @XmlAttribute(name = "proCode")
        public void setProCode(String proCode) {
            this.proCode = proCode;
        }

        public String getPrintIcon() {
            return printIcon;
        }

        @XmlAttribute(name = "printIcon")
        public void setPrintIcon(String printIcon) {
            this.printIcon = printIcon;
        }

        public String getErrMsg() {
            return errMsg;
        }

        @XmlAttribute(name = "errMsg")
        public void setErrMsg(String errMsg) {
            this.errMsg = errMsg;
        }

        public String getWaybillNo() {
            return waybillNo;
        }

        @XmlAttribute(name = "waybillNo")
        public void setWaybillNo(String waybillNo) {
            this.waybillNo = waybillNo;
        }
    }

}
