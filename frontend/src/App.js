import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Container } from 'react-bootstrap';
import { Route } from 'react-router-dom';
import Header from './component/Header';
import RecruitBoard from './container/recruitBoard/RecruitBoard';
import RecruitBoardSaveForm from './container/recruitBoard/RecruitBoardSaveForm';
import RecruitBoardView from './container/recruitBoard/RecruitBoardView';
import RecruitBoardUpdateForm from './container/recruitBoard/RecruitBoardUpdateForm';
import Home from './container/Home';
import Teams from './container/teams/Teams';
import TeamsDetail from './container/teams/TeamsDetail';
import TeamsSave from './container/teams/TeamsSave';
import TeamsUpdate from './container/teams/TeamsUpdate';

function App() {
  return (
    <div>
      <Header />
      <Container>
        <Route path="/" exact={true} component={Home} />
        <Route path="/recruitBoard" exact={true} component={RecruitBoard} />
        <Route
          path="/recruitBoardSaveForm"
          exact={true}
          component={RecruitBoardSaveForm}
        />
        <Route
          path="/recruitBoard/:recruitBoardId"
          exact={true}
          component={RecruitBoardView}
        />
        <Route
          path="/recruitBoardUpdateForm/:recruitBoardId"
          exact={true}
          component={RecruitBoardUpdateForm}
        />
        <Route path="/teams" exact={true} component={Teams} />
        <Route path="/teamsSave" exact={true} component={TeamsSave} />
        <Route path="/teams/:id" exact={true} component={TeamsDetail} />
        <Route path="/teamsUpdate/:id" exact={true} component={TeamsUpdate} />
      </Container>
    </div>
  );
}

export default App;
