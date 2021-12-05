package e1.util;

import e1.dto.Billete;

import java.util.List;

public sealed interface FiltroBilletes permits FiltroDestino, FiltroFecha, FiltroOrigen, FiltroPrecio {

    List<Billete> filtrar(List<Billete> billetes);

}