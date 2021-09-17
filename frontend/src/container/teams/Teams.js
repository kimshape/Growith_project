import React, { useContext, useEffect, useState } from 'react';
import { useHistory } from 'react-router';
import Slider from 'react-slick';
import TeamList from './TeamList';
import 'slick-carousel/slick/slick.css';
import 'slick-carousel/slick/slick-theme.css';

const Teams = () => {
  const [teams, setTeams] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/teams')
      .then((res) => res.json())
      .then((res) => {
        setTeams(res);
      });
  }, []);

  const settings = {
    dots: true,
    infinite: true,
    speed: 500,
    autoplay: false,
    autoplaySpeed: 3000,
    slidesToShow: 3,
    slidesToScroll: 3,
    centerMode: true,
    centerPadding: '0px',
  };

  return (
    <div className="row">
      <Slider {...settings}>
        {teams.map((team) => (
          <TeamList key={team.id} team={team} />
        ))}
      </Slider>
    </div>
  );
};

export default Teams;
