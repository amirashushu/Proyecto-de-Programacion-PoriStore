package logica;

import entidades.Administrador;
import entidades.Producto;
import java.util.ArrayList;
import entidades.Categorias;

public class SistemaTienda {
    private Administrador admin;
    private ArrayList<Producto> productos= new ArrayList();

    public SistemaTienda() {
        
    }
    public void CrearProducto(int n, String p, String s, double d, int c, Categorias z){
        
        Producto productoX = new Producto(n,p,s,d,c,z);
        productos.add(productoX);
        for (Producto pro: productos){
            System.out.println(pro.getNombre()+ pro.getPrecio()+pro.getStock()
            + pro.getDescripcion() + pro.getCategoria());
        }
    }
    
}
