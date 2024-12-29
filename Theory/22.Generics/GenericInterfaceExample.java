interface Repository<T> {
    void save(T data);
    T findById(int id);
}

// Implementation of the generic interface
class UserRepository implements Repository<String> {
    @Override
    public void save(String user) {
        System.out.println("User saved: " + user);
    }

    @Override
    public String findById(int id) {
        return "User" + id;
    }
}

// Usage
public class GenericInterfaceExample {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        userRepository.save("Vinod Murugan");
        System.out.println(userRepository.findById(1));
    }
}
