/**
 * Created by yixuanzhang on 1/28/19.
 */
public class Flags {
    private boolean payHousing;
    private boolean payApparel;
    private boolean payTransportation;
    private boolean payHealthcare;
    private boolean payEntertainment;
    private boolean payPersonal;
    private boolean payEducation;
    private boolean payInsurance;

    public Flags(){



    }

    public void setPayApparel(boolean payApparel) {
        this.payApparel = payApparel;
    }

    public void setPayEducation(boolean payEducation) {
        this.payEducation = payEducation;
    }

    public void setPayEntertainment(boolean payEntertainment) {
        this.payEntertainment = payEntertainment;
    }

    public void setPayHealthcare(boolean payHealthcare) {
        this.payHealthcare = payHealthcare;
    }

    public void setPayHousing(boolean payHousing) {
        this.payHousing = payHousing;
    }

    public void setPayInsurance(boolean payInsurance) {
        this.payInsurance = payInsurance;
    }

    public void setPayPersonal(boolean payPersonal) {
        this.payPersonal = payPersonal;
    }

    public void setPayTransportation(boolean payTransportation) {
        this.payTransportation = payTransportation;
    }

    public boolean isPayApparel() {
        return payApparel;
    }

    public boolean isPayEducation() {
        return payEducation;
    }

    public boolean isPayEntertainment() {
        return payEntertainment;
    }

    public boolean isPayHealthcare() {
        return payHealthcare;
    }

    public boolean isPayHousing() {
        return payHousing;
    }

    public boolean isPayInsurance() {
        return payInsurance;
    }

    public boolean isPayPersonal() {
        return payPersonal;
    }

    public boolean isPayTransportation() {
        return payTransportation;
    }

}


