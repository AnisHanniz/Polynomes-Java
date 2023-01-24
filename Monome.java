import java.lang.Math ; 
public class Monome {
    
    protected double coeff ; 
    protected int exposant ; 
    
    public Monome() {
        this.coeff = 0 ; 
        this.exposant = 0 ; 
    }
    
    public Monome(double c , int e) {
        this.coeff = c ; 
        this.exposant = e ;
    }
    
    public Monome(Monome m ) {
        m.coeff =this.coeff  ; 
        m.exposant= this.exposant  ;
    }

    public double getCoeff() {
        return coeff ;
    }
    
    public int getExposant() {
        return exposant ; 
    }
    
    public void  setCoeff(double c) {
          this.coeff = c ; 
    }
    public void  setExposant(int e) {
        this.exposant =e ; 
    }
    
    public double valeur(double x) {
        
        return Math.pow(x, (double) getExposant());
    }
    
    public Monome derive() {
        Monome m = new Monome();
        m.setCoeff(getCoeff()*getExposant());  
        m.setExposant(getExposant()-1);
        return m ; 
    }
    
    public Monome multMonome(Monome m1 ) {
        Monome m = new Monome();
        m.setCoeff(getCoeff()*m1.getCoeff());  
        m.setExposant(getExposant() + m1.getExposant());
        return m ; 
    }
    
    public  Monome addMonome(Monome m1) {
        
        if(getExposant()== m1.getExposant()) {
        m1.setCoeff(getCoeff()+m1.getCoeff());  
        m1.setExposant(getExposant());
    }
        return m1 ; 
    }
    public String toString() {
        String res ; 
        return res = getCoeff() + "X" + getExposant() ; 
    }
    

}
