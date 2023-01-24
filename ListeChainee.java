public class ListeChainee {
    
    
    protected Cellule tete ; 
    protected Cellule queue ; 
    
    public ListeChainee() {
        tete = null ; 
        queue = null  ; 
    }
    
    public ListeChainee(Cellule _tete){
        tete = _tete ; 
        //liste vide 
        queue = tete ; 
        Cellule tmp = tete ; 
        if ( tmp != null) {
            while(tmp.getSuivant()!=null) {
                tmp =tmp.getSuivant(); 
            }
        
        queue = tmp ; 
    }
    }
    
    public Cellule getTete() {
        return tete ; 
    }
    
    public Cellule getQueue() {
        return queue ; 
    }
    
    public boolean estVide() {
        return tete == null ; 
    }
    public Object enTete() {
        return getTete().getContenu() ; 
    }
    public Object enQueue() {
        return getQueue().getContenu(); 
    }
   
    public void ajouteTete(Object o_tete) {
        Cellule tete1 = new Cellule(o_tete) ;
         if(estVide()) {
             tete = tete1 ; 
             queue = tete1 ; 
         }else {
            tete1.setSuivant(tete);
            tete = tete1 ; 
         }
    }
    
    public void ajouteQueue(Object o_queue) {
        Cellule queue1 = new Cellule(o_queue) ; 
        if ( estVide()) {
            tete = queue1;
            queue = queue1 ; 
        }else {
        queue.setSuivant(queue1);
        queue = queue1 ; 
        
    }
    }
    
    public void retireTete() {
        if(tete == queue) {
            tete = null ; 
            queue = null ; 
        }else {
        Cellule anTete = tete ; 
        tete = tete.getSuivant();
        anTete.setSuivant(null); 
    }
    }
    
    public void retireQueue() {
        if(tete == queue) {
            tete = null ; 
            queue = null ; 
        }else {
            Cellule avantTmp = tete;
            while(avantTmp.getSuivant() != queue) {
                avantTmp =avantTmp.getSuivant(); 
            }
            avantTmp.setSuivant(null);
            queue = avantTmp ; 
            
        }
    }
    
    /*public void inserPos(int pos , Object o) {
        Cellule nouv = new Cellule(o) ; 
        Cellule tmp = tete ; 
        Cellule avantTmp = null ; 
        int i  =1  ; 
        while(tmp !=null && i!=pos) {
            avantTmp = tmp ; 
            tmp = tmp.getSuivant(); 
            i++ ; 
        }
        if(tmp== null) {
            System.out.println("er");
        }else {
        avantTmp.setSuivant(nouv);
        nouv.setSuivant(tmp);
    }
    }*/
    
    public int nbElemts() {
        int nb = 0 ; 
        Cellule tmp = getTete() ; 
        while(tmp!=null) {
            nb++ ; 
            tmp = tmp.getSuivant();
        }
        return nb ; 
    }
    
    public void inserePos(Object _o, int position) {//la première posision est 1
        if (position <= 0){
        System.out.println("position non valide");
        }
        else
        if (position == 1) {//liste vide ou non
        ajouteTete(_o);
        }
        else {
        Cellule c = new Cellule(_o);
        Cellule avant = null;
        Cellule apres = tete;
        int i = 1;
        while (i != position && apres != null) {
        avant = apres;
        apres = apres.getSuivant();
        i++;
        }
        if (apres == null) {
        System.out.println("position après fin de liste, pas d'insertion");
        }
        else {
        avant.setSuivant(c);
        c.setSuivant(apres);
        }
        }
        }
    
    public void retirePos(int pos) {
        if( pos <0) {
            System.out.println("err");
            }
        if (pos ==1) {
            retireTete(); 
        }
        if(pos==nbElemts()){
            System.out.println("allo"+nbElemts());
                retireQueue();
        }else{
            Cellule tmp = tete ; 
            Cellule avantTmp = null ; 
            int i =1 ; 
            while(tmp!=null && i!=pos) {
                avantTmp = tmp ; 
                tmp=tmp.getSuivant(); 
                i++ ;
            }
            if(tmp != null) {
            avantTmp.setSuivant(tmp.getSuivant());
            tmp.setSuivant(null);
            }else {
                System.out.println("err pos hors de la liste ");
            }
            }    
            
    }    
    public String toString(){
        if(estVide()){
            return "nil";
        }
        Cellule courante = tete;
        String resu = courante.toString();
        courante = courante.getSuivant();
        while(courante != null){
            resu = resu + " -> " +courante.toString();
            courante = courante.getSuivant();
        }
        return resu + " -> nil";
    }

}