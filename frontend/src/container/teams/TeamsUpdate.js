import React, { useEffect, useState } from 'react';
import { Button, Form } from 'react-bootstrap';

const TeamsUpdate = (props) => {
  const id = props.match.params.id;

  const [teams, setTeams] = useState({
    teamsName: '',
    teamsDescription: '',
  });

  useEffect(() => {
    fetch(`http://localhost:8080/teams/${id}`)
      .then((res) => res.json())
      .then((res) => {
        setTeams(res);
      });
  }, []);

  const changeValue = (e) => {
    setTeams({
      ...teams,
      [e.target.name]: e.target.value,
    });
  };
  const submitTeams = (e) => {
    e.preventDefault(); //submit이 action을 안 타고 자기 할일을 그만함.
    fetch(`http://localhost:8080/teams/${id}`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json; charset=utf-8',
      },
      body: JSON.stringify(teams),
    })
      .then((res) => {
        if (res.status === 200) {
          return res.json();
        } else {
          return null;
        }
      })
      .then((res) => {
        if (res !== null) {
          props.history.push('/teams');
        } else {
          alert('팀 등록에 실패하였습니다.');
        }
      });
  };

  return (
    <Form onSubmit={submitTeams}>
      <Form.Group className="mb-3" controlId="formBasicEmail">
        <Form.Label>팀 이름</Form.Label>
        <Form.Control
          type="text"
          placeholder="Enter TeamName"
          onChange={changeValue}
          name="teamsName"
          value={teams.teamsName}
        />
      </Form.Group>

      <Form.Group className="mb-3" controlId="formBasicEmail">
        <Form.Label>팀 설명</Form.Label>
        <Form.Control
          type="text"
          placeholder="Enter Description"
          onChange={changeValue}
          name="teamsDescription"
          value={teams.teamsDescription}
        />
      </Form.Group>

      <Button variant="primary" type="submit">
        Submit
      </Button>
    </Form>
  );
};

export default TeamsUpdate;
