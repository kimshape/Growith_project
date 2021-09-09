//package com.bit.growith.service;
//
//import com.bit.growith.dao.LoginRepository;
//import com.bit.growith.vo.Member;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Service
//@RequiredArgsConstructor
//public class MemberUserDetailsService implements UserDetailsService {
//
//    private final LoginRepository loginRepository;
//
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        Optional<Member> result = loginRepository.findByMemberEmail(username, false);
//
//        if(!result.isPresent()){
//            throw new UsernameNotFoundException("Check Email or Social");
//        }
//
//        Member member = result.get();
//
////        member = new Member( //dto
////                member.getMemberEmail(),
////                member.getMemberPw(),
////                member.isFromSocial(),
////                member.getRoleSet().stream().map(memberRole -> new SimpleGrantedAuthority("ROLE_"+memberRole.name())).collect(Collectors.toSet())
////        );
//        member.setMemberName(member.getMemberName());
//        member.setFromSocial(member.isFromSocial());
//
//        return null;
//    }
//}
