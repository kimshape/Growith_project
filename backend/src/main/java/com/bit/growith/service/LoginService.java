package com.bit.growith.service;

import com.bit.growith.vo.Member;

public interface LoginService {
    Object login(Member member);

    Object join(Member member);
}
