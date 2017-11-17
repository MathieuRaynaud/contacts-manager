package com.fredericboisguerin.insa;
import java.io.IOException;
import java.util.Scanner;

public class GeekUI {

    private ContactsManager NosContacts;



    public static void main(String[] args) throws IOException {
        GeekUI myGeekUI = new GeekUI();
        myGeekUI.displayMenu();
    }

    public GeekUI() throws IOException{
        this.NosContacts = new ContactsManager();
    }

    public GeekUI(ContactsManager cm){
        this.NosContacts = cm;
    }

    public void afficherAnnuaire(){
        System.out.println("**********");
        System.out.println("");
        System.out.println("Affichage de l'annuaire :");
        System.out.println("");
        NosContacts.printAllContacts();
        System.out.println("");
        System.out.println("**********");
        System.out.println("");
        System.out.println("");
    }

    public void ajouterContact() throws IOException{
        try {
            Scanner sc = new Scanner(System.in);
            String thisName;
            String thisEmail;
            String thisPhoneNumber;
            System.out.println("**********");
            System.out.println("");
            System.out.println("Entrez le nom :");
            thisName = sc.nextLine();
            System.out.println("Entrez l'email :");
            thisEmail = sc.nextLine();
            System.out.println("Entrez le numéro de téléphone :");
            thisPhoneNumber = sc.nextLine();
            System.out.println("");
            NosContacts.addContact(thisName, thisEmail, thisPhoneNumber);
            System.out.println("**********");
            System.out.println("");
        } catch (InvalidContactNameException e ) {
            System.out.println("Erreur lors de l'ajout : nom invalide.");
        } catch (InvalidEmailException f) {
            System.out.println("Erreur lors de l'ajout : email invalide.");
        }
    }

    public void rechercherContact(){
        Scanner sc = new Scanner(System.in);
        String nm;
        System.out.println("**********");
        System.out.println("");
        System.out.println("Menu de recherche d'un contact :");
        System.out.println("");
        System.out.println("Veuillez entrer le nom du contact à rechercher :");
        nm = sc.nextLine();
        NosContacts.searchContactByName(nm);
        System.out.println("");
        System.out.println("**********");
        System.out.println("");
        System.out.println("");
    }

    public void displayMenu() throws IOException{
        Scanner sc = new Scanner(System.in);
        String str;
        Boolean ok;
        Boolean finished = false;

        while (!finished) {
            ok = false;
            System.out.println("Menu principal - Entrez le chiffre correspondant à l'option souhaitée :");
            System.out.println("1 - Afficher l'annuaire");
            System.out.println("2 - Ajouter un contact");
            System.out.println("3 - Rechercher un contact");
            System.out.println("4 - Quitter");
            System.out.println("");

            while (!ok) {
                str = sc.nextLine();
                switch (str) {
                    case "1":
                        afficherAnnuaire();
                        ok = true;
                        break;
                    case "2":
                        ajouterContact();
                        ok = true;
                        break;
                    case "3":
                        rechercherContact();
                        ok = true;
                        break;
                    case "4":
                        System.out.println("Processus terminé.");
                        ok = true;
                        finished = true;
                        break;
                    default:
                        System.out.println("Mauvaise entrée, entrez une option correcte.");
                        break;
                }
            }
        }


    }

}
