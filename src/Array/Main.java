package Array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;

public class Main {

	public static Arreglo_usuarios lector(String path) {
		String csvFile = path;
		String line = "";
		String cvsSplitBy = ";";
		Arreglo_usuarios users = new Arreglo_usuarios();

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			br.readLine();// nos saltea la primera linea
			int leidos = 0;
			while ((line = br.readLine()) != null) {

				String[] items = line.split(cvsSplitBy);

				Usuario user = new Usuario(items);
				users.agregar(user);

				System.out.println("Leidos " + leidos++);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return users;
	}// fin lector

	public static void alta(Arreglo_usuarios usuarios) {
		long inicial = System.currentTimeMillis();
		
		String csvFile = "datasets/dataset_insert_10000.csv";
		String line = "";
		String cvsSplitBy = ";";
		BufferedWriter bw = null;

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			br.readLine();
			File file = new File("salidas/salidaAlta.csv");
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);

			long t1, t2 = System.nanoTime();
			int i=1;
			
			while ((line = br.readLine()) != null) {
				t1 = System.nanoTime();
				String[] items = line.split(cvsSplitBy);
				Usuario usuario = new Usuario(items);
				usuarios.agregar(usuario);

				String linea = usuario.imprimir() + ";" + (t1 - t2);
				bw.write(linea);
				bw.newLine();
				
				t2 = System.nanoTime();
				
				System.out.println("Alta "+ i++);
			}


		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (Exception ex) {
				System.out.println("Error cerrando el BufferedWriter" + ex);
			}
		}
		System.out.println("Tiempo total alta: "+ (System.currentTimeMillis()-inicial) + " ms");
	}

	public static void busqueda(Arreglo_usuarios usuarios){
		long inicial = System.currentTimeMillis();
		
		String csvFile = "datasets/dataset_busqueda_10000.csv";
		String line = "";
		String cvsSplitBy = ";";
		BufferedWriter bw = null;

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			br.readLine();
			File file = new File("salidas/salidaBusqueda.csv");
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			
			long t1, t2 = System.nanoTime();

			int i = 1;
			while ((line = br.readLine()) != null) {
				t1 = System.nanoTime();
				
				String[] items = line.split(cvsSplitBy);
				String linea = items[0] + ";" + usuarios.existe(items[0]) + ";" + (t1 - t2); 
				
				bw.write(linea);
				bw.newLine();
				
				t2 = System.nanoTime();
				System.out.println("Busqueda "+i++);
			} 
		}catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (Exception ex) {
				System.out.println("Error cerrando el BufferedWriter" + ex);
			}
		}
		System.out.println("Tiempo total: "+ (System.currentTimeMillis()-inicial) + " ms");
	}

	public static void main(String[] args) {

		Arreglo_usuarios usuarios = lector("datasets/dataset_3000000.csv");
		alta(usuarios);
	//	busqueda(usuarios);
		
	}// fin main
}

///////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////
