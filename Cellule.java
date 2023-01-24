import java.util.*;

public class Cellule {

  /**
   * objet encapsulé dans la cellule
   */
  protected Object contenu;
  /**
   * pointeur sur la cellule suivante
   */
  protected Cellule suivant;

  /**
   * constructeur créant une cellule sans contenu ni suivant
   */
  public Cellule() {
    contenu = null;
    suivant = null;
  }

  /**
   * constructeur créant une cellule encapsulant l'objet _contenu
   * @param _contenu l'objet à encapsuler
   */
  public Cellule(Object o_contenu) {
    contenu = o_contenu;
    suivant = null;
  }

  /**
   * accesseur de la cellule suivante
   * @return suivant
   */
  public Cellule getSuivant() {
    return suivant;
  }

  /**
   * modificateur du suivant
   * @param  la nouvelle cellule suivante
   */
  public void setSuivant(Cellule c_suivante) {
    suivant = c_suivante;
  }

  /**
   * modificateur du suivant
   * @param  un objet à encapsuler dans la future nouvelle cellule suivante
   */
  public void setSuivant(Object o_suivant) {
    suivant = new Cellule(o_suivant);
  }

  /**
   * accesseur du contenu
   * @return contenu
   */
  public Object getContenu() {
    return contenu;
  }

  /**
   * modificateur du contenu
   * @param  le nouveau contenu
   */
  public void setContenu(Object o_contenu) {
    contenu = o_contenu;
  }

  /**
   * repésentation de la cellule en chaîne de caractères
   */
  public String toString() {
    if (contenu == null) {
      return "nil";
    } else {
      return contenu.toString();
    }
  }
}
