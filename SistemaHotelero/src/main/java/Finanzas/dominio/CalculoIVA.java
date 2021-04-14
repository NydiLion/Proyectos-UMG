package Finanzas.dominio;

/*@author Diego Vásquez*/
public class CalculoIVA {

    private double porcentajeIVA;
    private double montoACalcular;
    private double montoSinIVA;
    private double montoIVA;

    /**
     * @return the porcentajeIVA
     */
    public double getPorcentajeIVA() {
        return porcentajeIVA;
    }

    /**
     * @param porcentajeIVA the porcentajeIVA to set
     */
    public void setPorcentajeIVA(double porcentajeIVA) {
        this.porcentajeIVA = porcentajeIVA;
    }

    /**
     * @return the montoACalcular
     */
    public double getMontoACalcular() {
        return montoACalcular;
    }

    /**
     * @param montoACalcular the montoACalcular to set
     */
    public void setMontoACalcular(double montoACalcular) {
        this.montoACalcular = montoACalcular;
    }

    public double getMontoIVA() {
        montoIVA = this.montoACalcular * (this.porcentajeIVA / 100);
        return montoIVA;
    }

    public double getMontoSinIVA() {
        montoSinIVA = this.montoACalcular - getMontoIVA();
        return montoSinIVA;
    }
}
