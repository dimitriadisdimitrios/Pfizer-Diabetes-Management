package gr.codehub.teamOne.repository;

import gr.codehub.teamOne.Utilities.GeneralFunctions;
import gr.codehub.teamOne.model.Users;
import gr.codehub.teamOne.repository.lib.Repository;
import gr.codehub.teamOne.representation.LoginCredentialDTO;
import gr.codehub.teamOne.representation.UsersDTO;
import gr.codehub.teamOne.representation.UsersSearchDTO;
import gr.codehub.teamOne.security.AccessRole;

import javax.persistence.EntityManager;
import java.util.List;

public class UserRepository extends Repository<Users, Long> {

    private EntityManager entityManager;

    public UserRepository(EntityManager entityManager) {
        super(entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public Class<Users> getEntityClass() {
        return Users.class;
    }

    @Override
    public String getEntityClassName() {
        return Users.class.getName();
    }

    /**
     * Method that  check if user exist on base before saving, based on email and Social Security number(amka).
     *
     * @param usersDTO Object of user that want to save on base
     * @return if exist other entry return true
     */
    public boolean checkIfAccountExist(UsersDTO usersDTO) {

        List userList = entityManager.createQuery("from Users u where u.email = :email or u.amka = :amka")
                .setParameter("email", usersDTO.getEmail())
                .setParameter("amka", usersDTO.getAmka())
                .getResultList();

        return userList.size() > 0;
    }
    /**
     * Method that check if user exist on base using email and password.
     *
     * @param  loginCredentialDTO contains the email and password
     * @return user with this email and password.
     */
    public List findUserWithCredential(LoginCredentialDTO loginCredentialDTO) {
        return entityManager.createQuery("from Users u where u.email = :email and u.password = :password")
                .setParameter("email", loginCredentialDTO.getUserEmail())
                .setParameter("password", loginCredentialDTO.getUserPassword())
                .getResultList();
    }

    /**
     * Search users with specific email.
     *
     * @param usrEmail  Contains the email  to search user.
     * @return User that found.
     */
    public Users getUserInfo(String usrEmail) {
        List tempListWithInfo = entityManager.createQuery("from Users u where u.email = :email")
                .setParameter("email", usrEmail)
                .getResultList();

        if (tempListWithInfo.size() > 0) {
            return (Users) tempListWithInfo.get(0);
        }
        return null;
    }
    /**
     * Search users with specific role.
     *
     * @param accessRole  Contains the role  to search user.
     * @return Users that found.
     */
    public List getAllUsersBasedOnRole(AccessRole accessRole) {

        return entityManager.createQuery("from Users u where u.accountType = :accessRole")
                .setParameter("accessRole", accessRole)
                .getResultList();
    }

    /**
     * Search user with specific amka. If input contains role, checks also if role is given
     *
     * @param usersSearchDTO Contains Social Security number(amka)to search user. In additional If contains and role, search on this criteria
     * @return User that found
     */
    public Users getUserBasedOnAmka(UsersSearchDTO usersSearchDTO) {

        List listWithAmka = entityManager.createQuery("from Users u where amka = :amka")
                .setParameter("amka", usersSearchDTO.getAmka())
                .getResultList();

        if (listWithAmka.size() > 0 ) {

            Users tempUsr = (Users) listWithAmka.get(0);
            if(usersSearchDTO.getRole() == null || usersSearchDTO.getRole() == tempUsr.getAccountType()) {
                return (Users) listWithAmka.get(0);
            }
        }
        return null;
    }

    public List getExpiredDoctors(){

        return entityManager.createQuery("from Users where accountType = :accountType and lastLogin != NULL and lastLogin > current_Date() - :daysToExp")
                .setParameter("accountType", AccessRole.ROLE_DOCTOR)
                .setParameter("daysToExp", GeneralFunctions.DaysToConsiderUserExpired)
                .getResultList();
    }
}