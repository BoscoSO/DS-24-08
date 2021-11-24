package e1.util;

import e1.dto.Billete;
import java.util.Comparator;
import java.util.List;

public interface FiltroBilletes {

    List<Billete> filtrar(List<Billete> billetes);

}