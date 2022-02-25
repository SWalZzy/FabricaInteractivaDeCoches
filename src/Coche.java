
public class Coche {
	
		public static final int MAX_COCHES = 5;
		public static int numCoches;
		private String matricula;
		private String marca;
		private String modelo;
		private String color;
		private boolean techoSolar;
		private float kilometros;
		private int numPuertas;
		private int numPlazas;
		
		
		public void tunear() {
			this.kilometros=0;
			if(this.techoSolar==false) {
				this.techoSolar=true;
				//System.out.println("Se le ha instalado techo solar ");
			}
		}
		public void tunear(String color) {
			tunear();
			this.color=color;
		}
		public void Avanzar(float f) {
			this.kilometros = this.kilometros + f;
			System.out.println("Se ha sumado "+f+"KM");
		}
		public void Matricular(String m) {
			this.matricula = m;
		}
		public Coche(String matri) {
			this.matricula = matri;
			this.marca="Seat";
			this.modelo="Altea";
			this.color="Blanco";
			this.numPuertas=3;
			this.numPlazas=5;
		}
		public Coche(int numPuertas,int numPlazas) {
			this.numPlazas=numPlazas;
			this.numPuertas=numPuertas;
			this.marca="Seat";
			this.modelo="Altea";
			this.color="Blanco";
		}
		public Coche() {
			this.marca="Seat";
			this.modelo="Altea";
			this.color="Blanco";
			this.numPuertas=3;
			this.numPlazas=5;
		}
		public Coche(String marca, String modelo, String color) {
			this.marca=marca;
			this.modelo=modelo;
			this.color=color;
			this.numPuertas=3;
			this.numPlazas=5;
		}
		public String getMatricula() {
			return matricula;
		}
		
		public void setMatricula(String matricula) {
			this.matricula = matricula;
		}

		public String getMarca() {
			return marca;
		}

		public void setMarca(String marca) {
			this.marca = marca;
		}

		public String getModelo() {
			return modelo;
		}

		public void setModelo(String modelo) {
			this.modelo = modelo;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public boolean getTechoSolar() {
			return techoSolar;
		}

		public void setTechoSolar(boolean techoSolar) {
			this.techoSolar = techoSolar;
		}

		public float getKilometros() {
			return kilometros;
		}

		public void setKilometros(float kilometros) {
			if(this.kilometros<0) {
				//System.out.println("Un coche no puede tener el contador de kilometros en negativo");
			}
			this.kilometros = kilometros;
		}

		public int getNumPuertas() {
			return numPuertas;
		}

		public void setNumPuertas(int numPuertas) {
			if(this.numPuertas<3 || this.numPuertas > 5) {
				//System.out.println("No podemos fabricar este coche");
			}
			this.numPuertas = numPuertas;
		}

		public int getNumPlazas() {
			return numPlazas;
		}

		public void setNumPlazas(int numPlazas) {
			if(this.numPlazas<2||this.numPlazas>7) {
				//System.out.println("No se puede fabricar este coche");
			}
			this.numPlazas = numPlazas;
		}
	}
