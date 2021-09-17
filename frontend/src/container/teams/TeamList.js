import React from 'react';
import { Button, Card } from 'react-bootstrap';
import { Link } from 'react-router-dom';

const TeamList = (props) => {
  const { teamsId, teamsName, teamsDescription } = props.team;

  return (
    <div className="col-md-3">
      <Card style={{ width: '15rem' }}>
        <Card.Img variant="top" src="holder.js/100px180" />
        <Card.Body>
          <Card.Title>
            <h4>{teamsName}</h4>
          </Card.Title>
          <Card.Text>{teamsDescription}</Card.Text>
          <Link to={'/teams/' + teamsId} className="btn btn-primary">
            상세보기
          </Link>
          {/* <Button variant="primary">Go somewhere</Button> */}
        </Card.Body>
      </Card>
      <br />
    </div>
    //   <Card.Body>
    //     <Card.Title>{teamsName}</Card.Title>
    //     <Link to={"/teams/" + teamsid} className="btn btn-primary">
    //       상세보기
    //     </Link>
    //   </Card.Body>
    // </Card>
  );
};

export default TeamList;
