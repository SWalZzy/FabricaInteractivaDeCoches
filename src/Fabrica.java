
import java.util.Scanner;
import java.util.Vector;

public class Fabrica {
	static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Vector vec = new Vector(4);
	int op = 0;
	do {
		System.out.println("1) Fabricar coche (conociendo la matrícula)");
		System.out.println("2) Fabricar coche (a partir del nº puertas y el nº de plazas)");
		System.out.println("3) Fabricar coche (a partir de la marca, wl modelo y el color)");
		System.out.println("4) Fabricar coche (cuando no tenemos ningun dato)");
		System.out.println("5) Tunnear coche (pintandolo de color)");
		System.out.println("6) Fabricar coche (sin pintarlo)");
		System.out.println("7) Avanzar kilómetros");
		System.out.println("8) Mostrar caracteristicas de un coche");
		System.out.println("9) Ordenar Coches:");
		System.out.println("10) Sumar cocher recursivo");
		System.out.println("11) Buscar coche recursivo");
		System.out.println("12) Salir del Programa");
		System.out.print("Elije una opcion: ");
		try {
			op= Integer.parseInt(teclado.next());
		}catch(Exception e) {
			System.out.print("Hay que introducir un valor numerico");
		}
	Menu(vec,op);
	}while(op!=12);
	}

	private static String caracteristicas(Coche c) {
		String tech;
		if(c.getTechoSolar()==true) {
			tech="Si";
		}else {
			tech="No";
		}
		
		return "\n Matricula: "+c.getMatricula()+"\n Marca: "+c.getMarca()+"\n Modelo: "+ c.getModelo()+
				"\n Color: "+c.getColor()+"\n Techo solar: "+tech+"\n KM: "+c.getKilometros()+"\n Nº Puertas: " + 
				c.getNumPuertas()+"\n Nº Plazas: "+c.getNumPlazas(); 
	}
	public static void Menu(Vector vec,int op) {
		Coche car1;
		Coche car2;
		Coche car3;
		Coche car4;
			switch(op) {
			case 1:
				if(Coche.numCoches<Coche.MAX_COCHES) {
					fabricarConMatricula(vec);
				}else {
					System.out.println("No se pueden crear mas coches");
				}
				break;
			case 2:
				if(Coche.numCoches<=Coche.MAX_COCHES) {
				fabricarConPuertasPlazas(vec);
				}else {
					System.out.println("No se pueden crear mas coches");
				}
				break;
			case 3:
				if(Coche.numCoches<=Coche.MAX_COCHES) {
					fabricarConMarca(vec);
				}else {
					System.out.println("No se pueden crear mas coches");
				}
				break;
			case 4:
				if(Coche.numCoches<=Coche.MAX_COCHES) {
					fabricarSinDatos(vec);
				}else {
					System.out.println("No se pueden crear mas coches");
				}
				break;
			case 5:
				System.out.print("Dame la matricula a buscar: ");
				String mat= teclado.next();
				Coche c=buscaCoche(vec,mat);
				if(c==null) {
					System.out.println("No se ha encontrado el coche: ");
				}else {
					System.out.print("Dame un color: ");
					String color=teclado.next();				
				}
			case 6:
				System.out.print("Dame la matricula: ");
				String mat1= teclado.next();
				Coche c1=buscaCoche(vec,mat1);
				if(c1==null) {
					System.out.println("No se ha encontrado el coche: ");
				}else {
					c1.tunear();
					System.out.println(caracteristicas(c1));
				}
				break;
			case 7:
				System.out.print("Dame la matricula: ");
				String mat11= teclado.next();
				Coche c11=buscaCoche(vec,mat11);
				if(c11==null) {
					System.out.println("No se ha encontrado el coche: ");
				}else {
					System.out.println("Dame kilometros a avanzar: ");
					int km=0;
					try {
						km = Integer.parseInt(teclado.next());
					}catch(Exception e) {
						System.out.println("Pon solo valores numericos");
					}
					c11.Avanzar(km);
				}
				break;
			case 8:
				for(int i=0;i<vec.size();i++){
					System.out.println("Car"+i+caracteristicas(((Coche)vec.get(i))));
				}
				break;
			case 9:
				System.out.println("1)Ordenar de forma iterativa");
				System.out.println("2)Ordenar de forma Recursiva");
				int resp=teclado.nextInt();
				if(resp==1) {
					OrdenarCoches(vec);
				}else {
					ordenarRecursivaPorKM(vec,0,0);
				}
				for(int i=0;i<vec.size();i++) {
					System.out.println("---------------");
					System.out.println(caracteristicas((Coche)vec.get(i)));
				}
				break;
			case 10:
				break;
			case 11:
				System.out.print("Dame la matricula a buscar: ");
				mat= teclado.next();
				c=BuscarcocheRecursivo(vec,mat,0);
				if(c==null) {
					System.out.println("No se ha encontrado el coche: ");
				}else {
					System.out.println(caracteristicas(c));				
				}
				break;
			case 12:
				System.out.println("Fin del programa. ");
				break;
			}
	}
	private static Coche BuscarcocheRecursivo(Vector vec, String mat, int i) {
		if(i==vec.size()) {
			
		}else {
			if(mat.equals(((Coche)vec.get(i)).getMatricula())){
				return (Coche)vec.get(i);
			}
		}
		return (Coche)vec.get(i);
		
	}

	private static void ordenarRecursivaPorKM(Vector vec, int i,int j) {
		Object aux;
		if(i==vec.size()-1) {
			
		}else {
			if(((Coche)vec.get(j+1)).getKilometros()>((Coche)vec.get(i)).getKilometros()){
				aux = vec.get(i);
				vec.set(i, vec.get(j+1));
				vec.set(j+1, aux);
			}
			if(j==vec.size()-2) {
				ordenarRecursivaPorKM(vec,i+1,i+1);
			}else {
				ordenarRecursivaPorKM(vec,i,j+1);
			}
		}
	}
	private static void OrdenarCoches(Vector vec) {
		// TODO Auto-generated method stub
		System.out.println("Dame opcion 1 mayor a menor y 2 menor a mayor: ");
		int num = teclado.nextInt();
		if(num==1) {
		for(int i=0;i<vec.size();i++){
			 for(int j=i;j<vec.size()-1;j++)     {
				 if(((Coche)vec.get(j+1)).getKilometros()>((Coche)vec.get(i)).getKilometros()){
					Object aux = vec.get(i);
					 vec.set(i, vec.get(j+1));
					 vec.set(j+1, aux);
				 }		
			}
		}
		}else {
			for(int i=0;i<vec.size();i++){
				 for(int j=i;j<vec.size()-1;j++)     {
					 if(((Coche)vec.get(j+1)).getKilometros()<((Coche)vec.get(i)).getKilometros()){
						Object aux = vec.get(i);
						 vec.set(i, vec.get(j+1));
						 vec.set(j+1, aux);
					 }
					 
				 }
			}
		}
		for(int i = 0;i<vec.size();i++) {
			System.out.println(caracteristicas((Coche)vec.get(i)));
		}
	}

	private static Coche buscaCoche(Vector vec, String mat) {
		Coche c=null;
		int i = 0;
		while(i < vec.size()&&c==null) {
			if(mat.equals(((Coche) vec.get(i)).getMatricula())) {
				c=(Coche)vec.get(i);
			}
			i++;
		}
		return c;
	}

	private static void fabricarSinDatos(Vector vec) {
		// TODO Auto-generated method stub
		String mat = matAleatoria();
		Coche c = new Coche();
		c.Matricular(mat);
		c.Avanzar((float)Math.floor(Math.random()*(100000-0+1))+0);
		
		vec.add(c);
		Coche.numCoches++;
		System.out.println(caracteristicas(c));
	}

	private static void fabricarConMarca(Vector vec) {
		// TODO Auto-generated method stub
		String mat=matAleatoria();
		System.out.print("Dama la marca");
		String marca = teclado.next();
		System.out.print("Dama el modelo");
		String modelo = teclado.next();
		System.out.print("Dama el color");
		String color= teclado.next();
		
		Coche c= new Coche(marca,modelo,color);
		c.Matricular(mat);
		
		vec.add(c);
		Coche.numCoches++;
		System.out.println(caracteristicas(c));
	}

	private static void fabricarConPuertasPlazas(Vector vec) {
		// TODO Auto-generated method stub
		String mat=matAleatoria();
		System.out.print("Dame Puertas");
		int pu=0;
		int pla=0;
		try {
			pu=Integer.parseInt(teclado.next());
		}catch(Exception e) {
			System.out.println("Tienes que introducir un valor numerico");
			pu=3;
		}
		try {
			pla=Integer.parseInt(teclado.next());
		}catch(Exception e) {
			System.out.println("Tienes que introducir un valor numerico");
			pla=5;
	}
		Coche c = new Coche();
		c.Matricular(mat);
		vec.add(c);
		Coche.numCoches++;
		System.out.println(caracteristicas(c));
}

	private static void fabricarConMatricula(Vector vec) {
		// TODO Auto-generated method stub
		System.out.print("Dame la matricula:");
		String mat=teclado.next();
		Coche c=new Coche(mat);
		vec.add(c);
		Coche.numCoches++;
		System.out.print(caracteristicas(c));
	}
	public static String matAleatoria() {
		String matricula="";
		String letras="BCDFGHJKLMNÑPQRSTVXZWY";
		for(int i=0;i<4;i++) {
			matricula = matricula+((int)(Math.random()*(9-0+1))+0);
		}
		matricula=matricula+"-";
		for(int i=0;i<2;i++) {
			matricula = matricula+((int)(Math.random()*(20-0+1))+0);
		}
		return matricula;
	}

}
