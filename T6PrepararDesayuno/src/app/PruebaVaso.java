package app;

import vajilla.Vaso;
import vajilla.exception.ExcepcionPrepararDesayuo;
import vajilla.exception.ExcepcionVasoNoCabe;

public class PruebaVaso {

	public static void main(String[] args) throws ExcepcionVasoNoCabe{

		Vaso vaso = new Vaso(10.0);

		//No se trata la excepción
		//vaso.llenar(15.0);
		 

		//Se trata la excepción 
		
		/*try {
			vaso.llenar(15.0);
		} catch (ExcepcionVasoNoCabe e) {
			System.err.println("Se excede la capacidad del vaso");
		}
		*/

		//No se trata la excepcion
		//vaso.prepararDesayuno1(10, 2, 1);

		//Se trata la excepción
		//vaso.prepararDesayuno2(10, 2, 1);

		//Se trata la excepción y se notifica al método main que ésta se ha producido
		
		/*try{
			vaso.prepararDesayuno3(10, 2, 1);
		} catch (ExcepcionPrepararDesayuo e){

			e.printStackTrace();
		}*/
		

	}

}
