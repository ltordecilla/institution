    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package institucioneducativa;

/**
 * Lista simplemente enlazada de estudiantes.
 */
public class ListaEstudiantes {

    private Nodo cabeza;

    public ListaEstudiantes() {
        cabeza = null;
    }

    /**
     * Retorna la cabeza de la lista.
     */
    public Nodo getCabeza() {
        return cabeza;
    }

    /**
     * Indica si la lista está vacía.
     */
    public boolean estaVacia() {
        return cabeza == null;
    }

    /**
     * Agrega un estudiante al final de la lista.
     */
    public void agregarFinal(Estudiante estudiante) {

        Nodo nuevo = new Nodo(estudiante);

        if (cabeza == null) {
            cabeza = nuevo;
            return;
        }

        Nodo actual = cabeza;

        while (actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }

        actual.setSiguiente(nuevo);
    }

    /**
     * Agrega un estudiante al principio de la lista.
     */
    public void agregarPrincipio(Estudiante estudiante) {

        Nodo nuevo = new Nodo(estudiante);

        nuevo.setSiguiente(cabeza);

        cabeza = nuevo;
    }

    /**
     * Inserta un nuevo estudiante después del estudiante
     * cuya identificación se recibe.
     */
    public boolean insertarDespuesDe(String identificacionAnterior,
                                      Estudiante estudiante) {

        Nodo actual = cabeza;

        while (actual != null) {

            if (actual.getEstudiante()
                    .getIdentificacion()
                    .equalsIgnoreCase(identificacionAnterior)) {

                Nodo nuevo = new Nodo(estudiante);

                nuevo.setSiguiente(actual.getSiguiente());

                actual.setSiguiente(nuevo);

                return true;
            }

            actual = actual.getSiguiente();
        }

        return false;
    }

    /**
     * Busca un estudiante por identificación.
     */
    public Estudiante buscarIdentificacion(String identificacion) {

        Nodo actual = cabeza;

        while (actual != null) {

            if (actual.getEstudiante()
                    .getIdentificacion()
                    .equalsIgnoreCase(identificacion)) {

                return actual.getEstudiante();
            }

            actual = actual.getSiguiente();
        }

        return null;
    }

    /**
     * Busca un estudiante por nombre.
     */
    public Estudiante buscarNombre(String nombre) {

        Nodo actual = cabeza;

        while (actual != null) {

            if (actual.getEstudiante()
                    .getNombre()
                    .equalsIgnoreCase(nombre)) {

                return actual.getEstudiante();
            }

            actual = actual.getSiguiente();
        }

        return null;
    }

    /**
     * Elimina un estudiante utilizando su identificación.
     */
    public boolean eliminar(String identificacion) {

        if (cabeza == null) {
            return false;
        }

        // Caso 1: eliminar el primer nodo.
        if (cabeza.getEstudiante()
                .getIdentificacion()
                .equalsIgnoreCase(identificacion)) {

            cabeza = cabeza.getSiguiente();

            return true;
        }

        Nodo actual = cabeza;

        while (actual.getSiguiente() != null) {

            if (actual.getSiguiente()
                    .getEstudiante()
                    .getIdentificacion()
                    .equalsIgnoreCase(identificacion)) {

                actual.setSiguiente(
                        actual.getSiguiente().getSiguiente()
                );

                return true;
            }

            actual = actual.getSiguiente();
        }

        return false;
    }

    /**
     * Elimina todos los estudiantes que están en quinto.
     */
    public int eliminarEstudiantesQuinto() {

        int cantidadEliminados = 0;

        // Eliminar los nodos de cabeza que sean de quinto.
        while (cabeza != null
                && cabeza.getEstudiante().getGrado() == 5) {

            cabeza = cabeza.getSiguiente();
            cantidadEliminados++;
        }

        // Eliminar nodos de quinto que estén después de la cabeza.
        Nodo actual = cabeza;

        while (actual != null
                && actual.getSiguiente() != null) {

            if (actual.getSiguiente()
                    .getEstudiante()
                    .getGrado() == 5) {

                actual.setSiguiente(
                        actual.getSiguiente().getSiguiente()
                );

                cantidadEliminados++;

            } else {

                actual = actual.getSiguiente();
            }
        }

        return cantidadEliminados;
    }

    /**
     * Retorna el estudiante de mayor edad de un determinado grado.
     */
    public Estudiante mayorEdadPorGrado(int grado) {

        Nodo actual = cabeza;
        Estudiante mayor = null;

        while (actual != null) {

            Estudiante estudiante = actual.getEstudiante();

            if (estudiante.getGrado() == grado) {

                if (mayor == null
                        || estudiante.getEdad() > mayor.getEdad()) {

                    mayor = estudiante;
                }
            }

            actual = actual.getSiguiente();
        }

        return mayor;
    }

    /**
     * Genera el informe de las mujeres de quinto.
     */
    public String informeMujeresQuinto() {

        Nodo actual = cabeza;

        int cantidadMujeres = 0;
        int sumaEdades = 0;

        StringBuilder resultado = new StringBuilder();

        resultado.append("INFORME DE MUJERES DE QUINTO\n");
        resultado.append("============================\n\n");

        while (actual != null) {

            Estudiante estudiante = actual.getEstudiante();

            if (estudiante.getGrado() == 5
                    && estudiante.getSexo().equalsIgnoreCase("F")) {

                resultado.append("Nombre: ")
                        .append(estudiante.getNombre())
                        .append("\n");

                resultado.append("Edad: ")
                        .append(estudiante.getEdad())
                        .append(" años\n\n");

                cantidadMujeres++;
                sumaEdades += estudiante.getEdad();
            }

            actual = actual.getSiguiente();
        }

        if (cantidadMujeres == 0) {

            resultado.append("No hay mujeres registradas en quinto.\n");

        } else {

            double promedio = (double) sumaEdades / cantidadMujeres;

            resultado.append("----------------------------\n");
            resultado.append("Cantidad de mujeres: ")
                    .append(cantidadMujeres)
                    .append("\n");

            resultado.append("Edad promedio: ")
                    .append(String.format("%.2f", promedio))
                    .append(" años\n");
        }

        return resultado.toString();
    }

    /**
     * Genera el informe de hombres y mujeres de primer grado.
     */
    public String informePrimerGrado() {

        Nodo actual = cabeza;

        int mujeres = 0;
        int hombres = 0;

        while (actual != null) {

            Estudiante estudiante = actual.getEstudiante();

            if (estudiante.getGrado() == 1) {

                if (estudiante.getSexo().equalsIgnoreCase("F")) {
                    mujeres++;
                } else if (estudiante.getSexo().equalsIgnoreCase("M")) {
                    hombres++;
                }
            }

            actual = actual.getSiguiente();
        }

        int total = mujeres + hombres;

        StringBuilder resultado = new StringBuilder();

        resultado.append("INFORME DE PRIMER GRADO\n");
        resultado.append("=======================\n\n");

        resultado.append("Mujeres: ")
                .append(mujeres)
                .append("\n");

        resultado.append("Hombres: ")
                .append(hombres)
                .append("\n");

        resultado.append("Total estudiantes: ")
                .append(total)
                .append("\n");

        return resultado.toString();
    }

    /**
     * Retorna la cantidad de estudiantes almacenados.
     */
    public int cantidadEstudiantes() {

        int cantidad = 0;

        Nodo actual = cabeza;

        while (actual != null) {

            cantidad++;

            actual = actual.getSiguiente();
        }

        return cantidad;
    }
}