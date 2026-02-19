public class TestGuia {

    static void buscarNombre(GuiaTelefonos guia, String nombre) {
        System.out.println(nombre + "->" + guia.buscarNombre(nombre));
    }

    static void buscarNumero(GuiaTelefonos guia, int numero) {
        System.out.println(numero + "->" + guia.buscarNumero(numero));
    }
    
    public static void main(String[] args) {
        GuiaTelefonos g = new GuiaTelefonos(10);
        g.poner(new Contacto("Luis", 123456));
        g.poner(new Contacto("Carlos", 3491234567l)); // Madrid
        g.poner(new Contacto("Pedro", 91345678)); // Madrid
        System.out.println(g);
        buscarNombre(g, "Carlos");
        buscarNombre(g, "Pedro");
        buscarNombre(g, "Antonio");
        buscarNumero(g, 123456);
        buscarNumero(g, 777777);
        g.quitar(new Contacto("Luis", 123456));
        System.out.println(g);
        g.poner(new Contacto("Luis", 654321));
        System.out.println(g);
        g.poner(new Contacto("Antonio", 123456));
        g.poner(new Contacto("Felipe", 567890));
        System.out.println(g);
        g.quitar(new Contacto("Carlos", 123456));
        System.out.println(g);
        g.quitar(new Contacto("Felipe", 567890)); 
        System.out.println(g);
        
        System.out.println(g.contarTelefonosMadrid());
    }

}
