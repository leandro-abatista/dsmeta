import logo from '../../assets/img/header.svg';
import './styles.css';
function Header() {
    return (
        <header>
            <div className="dsmeta-logo-container">
                <img src={logo} alt="ArfaxTechSoft" />
                <h1>ArfaxTechSoft</h1>
                <p>
                    Desenvolvido por
                    <a href="https://www.linkedin.com/in/leandro-amorim-batista/">Leandro Amorim</a>
                </p>
            </div>
        </header>
    )
}

export default Header;