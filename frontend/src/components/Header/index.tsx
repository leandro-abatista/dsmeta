import logo from '../../assets/img/header.svg';
import './styles.css';
function Header() {
    return (
        <header>
            <div className="dsmeta-logo-container">
                <img src={logo} alt="ArfaxTechSoft" />
                <h1>Sistema ATSMeta</h1>
                <p>
                    Desenvolvido por
                    <a href="https://www.linkedin.com/in/leandro-amorim-batista/"> ₢ArfaxTechSoft</a>
                </p>
            </div>
        </header>
    )
}

export default Header;