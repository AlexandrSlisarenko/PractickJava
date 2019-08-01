package ru.santos.BookkeepingSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ru.santos.BookkeepingSystem.ModelData.Card.OrderUser;
import ru.santos.BookkeepingSystem.ModelData.Order.Book;
import ru.santos.BookkeepingSystem.ModelData.User.Liked;
import ru.santos.BookkeepingSystem.ModelData.User.Role;
import ru.santos.BookkeepingSystem.ModelData.User.User;
import ru.santos.BookkeepingSystem.repos.UserRepo;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private MailSender mailSender;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private LikedService likedService;
    @Autowired
    private BookService bookService;
    @Autowired
    private CardUserService cardUserService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException("User not found!!!");
        }

        return userRepo.findByUsername(username);
    }



    public boolean addUser(User user){
        User userFromDB = userRepo.findByUsername(user.getUsername());

        if(userFromDB != null){

            return false;
        }

        user.setActiv(true);
        user.setRoles(Collections.singleton(Role.USER));
        user.setActivationCode(UUID.randomUUID().toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
        sendActivationCode(user);
        return true;
    }

    private void sendActivationCode(User user) {
        if(!StringUtils.isEmpty(user.getEmail())){
            String message = String.format(
                    "Hello. %s! \n"+
                            "Welocome to Sweater. Please next visit next link http://localhost:8080/activate/%s",
                    user.getUsername(),
                    user.getActivationCode()
            );
            mailSender.send(user.getEmail(),"Activation code", message);
        }
    }

    public boolean activateUser(String code) {
        User user = userRepo.findByActivationCode(code);

        if(user == null){
            return false;
        }

        user.setActivationCode(null);
        userRepo.save(user);
        return true;
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public void saveUser(String username, Map<String, String> form, User user) {
        user.setUsername(username);
        Set<String> roles = Arrays.stream(Role.values()).map(Role::name).collect(Collectors.toSet());

        user.getRoles().clear();
        for (String key : form.keySet()) {
            if(roles.contains(key)){
                user.getRoles().add(Role.valueOf(key));
            }
        }
        userRepo.save(user);
    }

    public void updateProfile(String email, String pass, User user){
        String userEmail = user.getEmail();

        boolean isEmailChanged =(email != null && !email.equals(userEmail))||(userEmail != null && !userEmail.equals(email));
        if(isEmailChanged){
            user.setEmail(email);
            if(!StringUtils.isEmpty(email)){
                user.setActivationCode(UUID.randomUUID().toString());
            }
        }
        if(!StringUtils.isEmpty(pass)){
            user.setPassword(pass);
        }

        userRepo.save(user);

        if(isEmailChanged) {
            sendActivationCode(user);
        }
    }

    public ArrayList<Book> getLikedBooks(Long id) {
        ArrayList<Book> res = new ArrayList<>();
        List<Liked> likedlist = likedService.findByUserId(id);
        for (int i = 0; i < likedlist.size(); i++) {
            res.add(bookService.findBookById(likedlist.get(i).getBook_id()));
        }
        return res;
    }

    public void saveLikedBook(Integer bookId, Long id) {
        List<Liked> like = likedService.findByUserIdAndBookId(id, bookId);
        if(like.size() == 0){
            Liked nLike = new Liked();
            nLike.setBookId(bookId);
            nLike.setUserId(id);
            likedService.saveLike(nLike);
        }
    }

    public void deleteLikedBook(Integer bookId, Long id) {
        List<Liked> delLike = likedService.findByUserIdAndBookId(id, bookId);
        for (int i = 0; i < delLike.size(); i++) {
            likedService.deleteLike(delLike.get(i));
        }
    }

    public void addMany(User user, String many) {
        user.setMany(Integer.parseInt(many));
        userRepo.save(user);
    }

    public void saveUserInDB(User user) {
        userRepo.save(user);
    }

    public HashMap<String, Integer> getLikeGenre(Long id) {
        return cardUserService.getGenreList(id);
    }

    public User getUser(Long id){
        return userRepo.findById(id).get();
    }
}
