package tn.ISTIC.Security;



import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tn.ISTIC.Models.User;
import tn.ISTIC.Repository.UserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetailsImpl loadUserByUsername(String email) throws UsernameNotFoundException {

		Optional<User> user = userRepo.findByEmail(email);
		if (user.isPresent()) {
			return new UserDetailsImpl(user.get());
		}

		throw new UsernameNotFoundException("cannot find email = " + email);

	}
}
