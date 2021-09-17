import React, { useEffect, useState } from 'react';
import { Button } from 'react-bootstrap';

const TeamsDetail = (props) => {
  const id = props.match.params.id;

  const [teams, setTeams] = useState({
    teamsName: '',
    teamsDescription: '',
    teamsInstDate: '',
  });

  useEffect(() => {
    fetch(`http://localhost:8080/teams/${id}`)
      .then((res) => res.json())
      .then((res) => {
        setTeams(res);
      });
  }, []);
  const updateTeams = () => {
    props.history.push(`/teamsUpdate/${id}`);
  };
  const deleteTeams = () => {
    fetch(`http://localhost:8080/teams/${id}`, { method: 'DELETE' })
      .then((res) => res.text())
      .then((res) => {
        if (res === 'ok') {
          props.history.push('/teams');
        } else {
          alert('삭제실패');
        }
      });
  };
  return (
    <div>
      <Button onClick={updateTeams}>수정</Button>{' '}
      <Button onClick={deleteTeams}>삭제</Button>
      <hr />
      <h3>{teams.teamsName}</h3>
      <h3>{teams.teamsDescription}</h3>
      <h3>팀 생성일 : {teams.teamsInstDate}</h3>
    </div>
  );
};

export default TeamsDetail;
