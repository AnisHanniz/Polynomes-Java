/*public class Polynome{
    private ListeChainee l_monomes;
    
    public Polynome(){
        l_monomes = new ListeChainee();
    }
    
    public int nbElements(){
        if(l_monomes.estVide())return 0;
            Cellule tmp = l_monomes.getTete();
            int i = 0;
        while(tmp!=null){
            i++;
            tmp=tmp.getSuivant();
        }
        return i;
    }
    public void addMonome(Monome o_monome){
        if(l_monomes.estVide() || o_monome.getExposant()==0){
            l_monomes.ajouteTete(o_monome);
        }else if(o_monome.getExposant()>=((Monome)l_monomes.getQueue().getContenu()).getExposant()){
                l_monomes.ajouteQueue(o_monome);
        }else{
            Cellule tmp = l_monomes.getTete();
            int pos = 1;
            while(((Monome)tmp.getContenu()).getExposant()<o_monome.getExposant()){
                tmp=tmp.getSuivant();
                pos++;
                }
                }
                addDoublon();
        }

    public void addDoublon(){
        if(nbElements()>=2){
            int pos = 2;
            Cellule tmp1 = null;
            Cellule tmp2 = l_monomes.getTete();
            while(tmp2!=null){
                if(tmp1!=null && (((Monome)tmp1.getContenu()).getExposant()==((Monome)tmp2.getContenu()).getExposant())){
                Monome m = ((Monome)tmp2.getContenu()).addMonome(((Monome)tmp1.getContenu()));
                tmp1 = null ;
                l_monomes.retirePos(pos);
                }
                tmp1=tmp2;
                tmp2=tmp2.getSuivant();
                pos++;
            }
        }
    }
    
    
    
    public String toString(){
        String str = "";
        if(!l_monomes.estVide()){
        Cellule tmp = l_monomes.getTete();
        while (tmp!=null){
        str += "->"+tmp.toString();
        tmp=tmp.getSuivant();
        }
        return str;
        }
        else{
            return "Chaine vide!";
        }
        
    }
}*/

public class Polynome {
    
    protected ListeChainee liste ; 
    
    public Polynome() {
        liste = new ListeChainee() ; 
    }
    
    public Polynome(ListeChainee l) {
        liste = l ; 
    }
    
    public Polynome(Polynome p) {
        liste = p.liste ; 
    }
    
    public ListeChainee getListe() {
        return liste ; 
    }
    
    public void setListe(ListeChainee l) {
        liste = l ; 
    }
    
    public void addMonome(Monome m) {
        if(liste.estVide()) {
            liste.ajouteTete(m);
        }else {
            Cellule tmp = liste.getTete() ; 
            while(tmp!=null) {
                if(((Monome)tmp.getContenu()).getExposant()==m.getExposant()) {
                    ((Monome)tmp.getContenu()).setCoeff(((Monome)tmp.getContenu()).getCoeff()+m.getCoeff());
                    break ; 
                }
                tmp = tmp.getSuivant();
            }
            if(tmp==null) {
                liste.ajouteQueue(m);
            }
        }
        ordonner();
    }
    
    public void ordonner(){
        Cellule tmp1 = liste.getTete(); 
        Cellule tmp2 = liste.getTete().getSuivant() ; 
            while(tmp2!=null) {
                if((((Monome)tmp2.getContenu()).getExposant())<(((Monome)tmp1.getContenu()).getExposant())){
                    int i = ((Monome)tmp1.getContenu()).getExposant();
                    int j = ((Monome)tmp2.getContenu()).getExposant();
                    double ic = ((Monome)tmp1.getContenu()).getCoeff();
                    double jc = ((Monome)tmp2.getContenu()).getCoeff();
                    ((Monome)tmp1.getContenu()).setExposant(j);
                    ((Monome)tmp1.getContenu()).setCoeff(jc);
                    ((Monome)tmp2.getContenu()).setExposant(i);
                    ((Monome)tmp2.getContenu()).setCoeff(ic);
                }
            tmp1=tmp1.getSuivant();
            tmp2=tmp2.getSuivant();
            }
    }
    
    public int getNbMonomes() {
        int nb = 0 ; 
        Cellule tmp = liste.getTete() ; 
        while(tmp!=null) {
            nb++ ; 
            tmp = tmp.getSuivant();
        }
        return nb ; 
    }
    
    public double valeur(double x) {
        double res = 0 ; 
        Cellule tmp = liste.getTete() ; 
        while(tmp!=null) {
            res += ((Monome)tmp.getContenu()).valeur(x);
            tmp = tmp.getSuivant();
        }
        return res ; 
    }
    
    public Polynome derive() {
        Polynome p = new Polynome();
        Cellule tmp = liste.getTete() ; 
        while(tmp!=null) {
            p.addMonome(((Monome)tmp.getContenu()).derive());
            tmp = tmp.getSuivant();
        }
        return p ; 
    }
    
    private int getPos(Cellule m){
            Cellule tmp = liste.getTete();
            int i = 0;
            while(tmp.getContenu()!=m.getContenu()){
                    tmp=tmp.getSuivant();
                    i++;
            }
            return i;
    }
    
    public void nettoie() {
        Cellule tmp = liste.getTete() ; 
        while(tmp!=null) {
            if(((Monome)tmp.getContenu()).getCoeff()==0) {
                    if(getPos(tmp)==1){
                            liste.retirePos(1);
                    }
                    else if(getPos(tmp)==getNbMonomes()){
                            liste.retireQueue();
                    }
                    else{
                            liste.retirePos(getPos(tmp));
                            
                    }
            }
            tmp=tmp.getSuivant();
        }
    }
    
    public Polynome addPolynome(Polynome p) {
        Polynome p1 = new Polynome();
        Cellule tmp = liste.getTete() ; 
        Cellule tmp1 = p.getListe().getTete() ; 
        while(tmp!=null && tmp1!=null) {
            p1.addMonome(((Monome)tmp.getContenu()).addMonome((Monome)tmp1.getContenu()));
            tmp = tmp.getSuivant();
            tmp1 = tmp1.getSuivant();
        }
        while(tmp!=null){
              p1.addMonome(((Monome)tmp.getContenu()));
              tmp = tmp.getSuivant();
        }
        while(tmp1!=null){
              p1.addMonome(((Monome)tmp1.getContenu()));
              tmp1 = tmp1.getSuivant();
        }
        return p1 ; 
    }
    
    public Polynome multPolynome(Polynome p) {
        Polynome p1 = new Polynome();
        Cellule tmp = liste.getTete() ; 
        Cellule tmp1 = p.getListe().getTete() ; 
        while(tmp!=null && tmp1!=null) {
            p1.addMonome(((Monome)tmp.getContenu()).multMonome((Monome)tmp1.getContenu()));
            tmp = tmp.getSuivant();
            tmp1 = tmp1.getSuivant();
        }
        while(tmp!=null){
              p1.addMonome(((Monome)tmp.getContenu()));
              tmp = tmp.getSuivant();
        }
        while(tmp1!=null){
              p1.addMonome(((Monome)tmp1.getContenu()));
              tmp1 = tmp1.getSuivant();
        }
        return p1 ; 
    }
    
    public String toString() {
        String res = "" ; 
        Cellule tmp = liste.getTete() ; 
        while(tmp!=null) {
            res += tmp.getContenu().toString() + " + " ; 
            tmp = tmp.getSuivant();
        }
        return res ; 
    }
    }