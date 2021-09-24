import React, { useState } from 'react';
import { Button, Form } from 'react-bootstrap';

const JoinForm = (props) => {
  const [member, setMember] = useState({
    username: '',
    password: '',
    email: '',
  });

  const changeValue = (e) => {
    setMember({
      ...member,
      [e.target.name]: e.target.value,
    });
  };
  const submitJoinForm = (e) => {
    e.preventDefault(); //submit이 action을 안 타고 자기 할 일을 그만함
    fetch('http://localhost:8080/member', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json; charset=utf-8',
      },
      body: JSON.stringify(member),
    })
      .then((res) => {
        console.log(1, res);
        if (res.status === 201) {
          return res.json();
        } else {
          return null;
        }
      })
      .then((res) => {
        console.log('정상', res);
        if (res !== null) {
          alert('회원가입 완료');
          props.history.push('/');
        } else {
          alert('작성에 실패하였습니다.');
        }
      })
      .catch((error) => {
        console.log('실패', error);
      });
  };

  return (
    <Form onSubmit={submitJoinForm}>
      <Form.Group className="mb-3">
        <Form.Label>유저이름</Form.Label>
        <Form.Control
          type="text"
          placeholder="내용을 입력해주세요."
          onChange={changeValue}
          name="username"
        />
        <Form.Label>비밀번호</Form.Label>
        <Form.Control
          type="password"
          placeholder="내용을 입력해주세요."
          onChange={changeValue}
          name="password"
        />
        <Form.Label>이메일</Form.Label>
        <Form.Control
          type="text"
          placeholder="내용을 입력해주세요."
          onChange={changeValue}
          name="email"
        />
      </Form.Group>
      <Button variant="primary" type="submit">
        회원가입
      </Button>
    </Form>
  );
};
export default JoinForm;
