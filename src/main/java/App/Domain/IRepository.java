package App.Domain;

import java.util.List;

public interface IRepository<Item> {
    public Item create(Item item);

    public int update(Item item);

    public boolean delete(int id);

    public List<Book> get(String id) throws Exception;

    public List<Item> get();
}
