package tech.icei.dao;

import tech.icei.model.Editorial;

public interface EditorialDAO {
    public Editorial getEditorial(int id);

    public void save(Editorial editorial);
}
