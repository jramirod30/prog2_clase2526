public class TestGuia2 {

    static void buscarNombre(GuiaTelefonosOrd guia, String nombre) {
        System.out.println(nombre + "->" + guia.buscarNombre(nombre));
    }

    static void buscarNumero(GuiaTelefonosOrd guia, int numero) {
        System.out.println(numero + "->" + guia.buscarNumero(numero));
    }
    
    public static void main(String[] args) {
        GuiaTelefonosOrd g = new GuiaTelefonosOrd(10);
        g.poner(new Contacto("Luis", 123456));
        g.poner(new Contacto("Carlos", 3491234567l)); // Madrid
        g.poner(new Contacto("Pedro", 91345678)); // Madrid
        System.out.println(g);
        
        GuiaTelefonosOrd g1 = new GuiaTelefonosOrd(g);
        System.out.println(g1);
        
        System.out.println(g.esIgual(g1)); // true
        g1.quitar(new Contacto("Pedro", 91345678));
        System.out.println(g.esIgual(g1)); // false
        
        Contacto[] contactos = g.getTelefonosMadrid();
        for (int i=0; i<contactos.length; i++) // dos contactos de Madrid
        	System.out.println(contactos[i]);
    }

}
