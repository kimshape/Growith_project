import React from 'react';
import {
  Button,
  Container,
  Form,
  FormControl,
  Nav,
  Navbar,
} from 'react-bootstrap';
import { Link } from 'react-router-dom';

const Header = () => {
  return (
    <>
      <br />
      <Navbar bg="light" variant="light">
        <Container>
          <Link to="/" className="navbar-brand">
            <img
              src="img/growith_logo_transparent.svg"
              width="250"
              height="42"
              className="d-inline-block align-top"
              alt="Growith logo"
            />
          </Link>
          <Nav className="me-auto">
            <Link to="/joinForm" className="nav-link">
              회원가입
            </Link>
            <Link to="/loginForm" className="nav-link">
              로그인
            </Link>
            <Link to="/recruitBoard" className="nav-link">
              게시판
            </Link>
            <Link to="/recruitBoardSaveForm" className="nav-link">
              글쓰기
            </Link>
          </Nav>
        </Container>
        <Form className="d-flex">
          <FormControl type="search" placeholder="Search" aria-label="Search" />
          <Button variant="light">Search</Button>
        </Form>
      </Navbar>
    </>
  );
};
export default Header;
