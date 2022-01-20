import { Container, Navbar, Nav } from 'react-bootstrap';
import '../assets/css/navbar.css';

function ReactNavbar() {
  return (
    <Navbar bg="dark" variant="dark">
      <Container>
        <Navbar.Brand>BuildingInfo</Navbar.Brand>
        <Nav className="me-auto">
          <Nav.Link href="\">Home</Nav.Link>
          <Nav.Link href="\set">Set Building</Nav.Link>
        </Nav>
      </Container>
    </Navbar>
    );
}   

export default ReactNavbar;
