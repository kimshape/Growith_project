import React from 'react';
import { Card } from 'react-bootstrap';
import { Link } from 'react-router-dom';

const RecruitBoardItem = (props) => {
  const { recruitBoardId, recruitBoardContent } = props.recruitBoard;
  return (
    <Card>
      <Card.Body>
        <Card.Title>{recruitBoardContent}</Card.Title>
        <Link
          to={'/recruitBoard/' + recruitBoardId}
          className="btn btn-primary"
        >
          상세보기
        </Link>
      </Card.Body>
    </Card>
  );
};

export default RecruitBoardItem;
