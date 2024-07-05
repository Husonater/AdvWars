public abstract  class Ground extends Troops {
    /*status 0 heisst das sie auf dem Boden sind, 1 fuer Luft, 2 fuer Schiffe, dies kann man gebrauchen um spaeter ein switch case zu machen um 
    ground troops den access auf den See zu verweigern bsp. 
    sowas kann in game handler
    switch(status){
        case 0:
            // not allowed on see
            break;
        case 1:
            //allowed everywhere
            break;
        case 2:
            //only allowed on see
            break;


     */
    int status = 0;


    public static void main(String[] args) {
        
    }

    public int status() {
        return status;
    }

    
}
