
public class Main
{
	public static void main(String[] args) {
	        /*
	        ListeChainee li = new ListeChainee();
	        li.ajouteTete(5);
	        li.ajouteTete(6);
	        li.ajouteTete(7);
	        li.retirePos(3);
	        System.out.println(li);*/
	        Polynome p = new Polynome();
	        Monome m1 = new Monome(1,1);
	        p.addMonome(m1);
	        //System.out.println(p);
	        Monome m2 = new Monome(1,1);
	        p.addMonome(m2);
	        //System.out.println(p);
	        Monome m3 = new Monome(1,1);
	        p.addMonome(m3);
	        //System.out.println(p);
	        Monome m4 = new Monome(1,2);
	        p.addMonome(m4);
	        //System.out.println(p);
	        Monome m5 = new Monome(1,5);
	        p.addMonome(m5);
	        p.addMonome(new Monome(1,5));
	        p.addMonome(new Monome(3,1));
	        p.addMonome(new Monome(1,2));
	        p.addMonome(new Monome(1,3));
	        p.addMonome(new Monome(1,7));
	        System.out.println("p1 : "+p);
	        
	        Polynome p2 = new Polynome();
	        Monome pm1 = new Monome(1,1);
	        p2.addMonome(pm1);
	        Monome pm2 = new Monome(1,2);
	        p2.addMonome(pm2);
	        Monome pm3 = new Monome(1,3);
	        p2.addMonome(pm3);
	        
	        System.out.println("p2 : "+p2);
	        Polynome p3 = p.multPolynome(p2) ;
	        System.out.println("p3 : "+p3);
	        Monome pm4 = new Monome(0,8);
	        p3.addMonome(pm4);
	        Monome pm5 = new Monome(0,9);
	        p3.addMonome(pm5);
	        Monome pm6 = new Monome(0,1);
	        p3.addMonome(pm6);
	        System.out.println("p3 : "+p3);
	        p3.nettoie();
	        System.out.println("p3 après nettoyage : "+p3);
	        
	        
	}
}
